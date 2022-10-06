package com.mdonline.LoginService.Security.Jwt;

import com.mdonline.LoginService.Model.User;
import com.mdonline.LoginService.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenFilter.class);
    private JwtTokenUtil jwtTokenUtil;
    private Utility utility;

    /**
     * Main constructor for JWT Token Filter.
     *
     * @param jwtTokenUtil - Initializes JWT token util for jwt related utility access
     */
    @Autowired
    public JwtTokenFilter(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    /**
     * This functions Overrides default internal filtering configuration
     *
     * @param request - Handles incoming request data
     * @param filterChain -
     * @param response - provides a response for the requested data
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        LOGGER.trace("Internal filtering");
        // Break filter if there is no Authorization bearer
        if (!hasAuthorizationBearer(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Get token of incoming request
        String token = getAccessToken(request);

        // Break filter if token is invalid
        if (!jwtTokenUtil.validateAccessToken(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Set the authentication context
        setAuthenticationContext(token, request);

        // Do filtering
        filterChain.doFilter(request, response);
    }

    /**
     * This function checks to see if incoming request has an authorization bearer.
     *
     * @param request - Handles incoming request
     * @Return - Boolean if request has authorization bearer
     */
    private boolean hasAuthorizationBearer(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
            LOGGER.trace("No Bearer in Authorization");
            return false;
        }
        return true;
    }

    /**
     * This function returns the token included in the request
     *
     * @param request - Handles incoming request
     * @Return - Boolean if request has authorization bearer
     */
    private String getAccessToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = header.split(" ")[1].trim();
        return token;
    }

    /**
     * This function sets the Authentication Context. Assigns user with authority.
     *
     * @param request - Handles incoming request
     * @param token - Request token
     */
    private void setAuthenticationContext(String token, HttpServletRequest request) {
        LOGGER.trace("Setting authentication context for JWT");
        UserDetails userDetails = getUserDetails(token);

        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(userDetails, null, null);

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    /**
     * This function returns the UserDetails from a JWT.
     *
     * @param token - Request token
     * @Return - UserDetails
     */
    private UserDetails getUserDetails(String token) {
        LOGGER.trace("Getting User Details from JWT");
        // TODO : Separate tasks for doctor and patient
        User userDetails = new User();

        try {
            String[] jwtSubject = jwtTokenUtil.getSubject(token).split(",");
            userDetails.setId(Long.parseLong(jwtSubject[0]));
            userDetails.setEmail(jwtSubject[1]);
        }catch (Exception e){
            LOGGER.error("Could not get user details in: getUserDetails()");
        }

        if (userDetails.getId() == null || userDetails.getEmail() == null){
            LOGGER.warn("Returning null user in: getUserDetails()");
        }
        return userDetails;
    }
}
