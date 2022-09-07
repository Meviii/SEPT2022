package com.mdonline.LoginService.Jwt;

import com.mdonline.LoginService.User.User;
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

    @Autowired
    public JwtTokenFilter(JwtTokenUtil jwtTokenUtil, Utility utility) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.utility = new Utility();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (!hasAuthorizationBearer(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = getAccessToken(request);

        if (!jwtTokenUtil.validateAccessToken(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        setAuthenticationContext(token, request);
        filterChain.doFilter(request, response);
    }

    private boolean hasAuthorizationBearer(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
            LOGGER.trace("No Bearer in Authorization");
            return false;
        }

        return true;
    }

    private String getAccessToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = header.split(" ")[1].trim();
        return token;
    }

    private void setAuthenticationContext(String token, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(token);

        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(userDetails, null, null);

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private UserDetails getUserDetails(String token) {
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
