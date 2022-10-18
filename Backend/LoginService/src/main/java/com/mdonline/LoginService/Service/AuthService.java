package com.mdonline.LoginService.Service;

import com.mdonline.LoginService.Model.Auth.AuthRequest;
import com.mdonline.LoginService.Model.Auth.AuthResponse;
import com.mdonline.LoginService.Model.User;
import com.mdonline.LoginService.Security.Jwt.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);

    /**
     * Main constructor for the Auth service.
     *
     * @param authenticationManager - Initializes the Authentication Manager which authenticates an auth request
     * @param jwtTokenUtil - Initializes the JWT Token utility class
     * @param restTemplate - Initializes the Rest Template for microservice communication
     */
    @Autowired
    public AuthService(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, RestTemplate restTemplate) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.restTemplate = restTemplate;
    }

    /**
     * Returns a new AuthResponse which consists of User details iff authentication is successful.
     *
     * @param request - AuthRequest
     * @Return - AuthResponse
     */
    public AuthResponse canAuthenticate(AuthRequest request) {
        LOGGER.info("Authenticating JWT");
        // Authenticate user passed by auth request
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        // Get user principal
        User user = (User) authentication.getPrincipal();

        // Generate Token
        String accessToken = jwtTokenUtil.generateAccessToken(user);

        // Return new Auth Response
        return new AuthResponse(user.getEmail(), accessToken);
    }

    /**
     * Creates a new User from JsonString payload via calling the account microservice
     *
     * @param jsonString - JsonString of user payload
     */
    public void register(String jsonString) {
        LOGGER.info("Registering User via AccountService");
        try {
            restTemplate.postForObject("http://account-service/api/v1/user", jsonString, String.class);
        }catch (Exception e){
            LOGGER.warn("Couldn't register user. AccountService might not be on");
        }
    }
}

