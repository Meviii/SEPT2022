package com.mdonline.LoginService.Service;

import com.mdonline.LoginService.Security.Auth.AuthRequest;
import com.mdonline.LoginService.Security.Auth.AuthResponse;
import com.mdonline.LoginService.Security.Jwt.JwtTokenUtil;
import com.mdonline.LoginService.Model.User;
import com.mdonline.LoginService.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private final UserService userService;
    private final Utility utility;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final RestTemplate restTemplate;

    /**
     * Main constructor for the Auth service.
     *
     * @param userService - Initializes global admin repository
     * @param passwordEncoder - Initializes global Bcrypt password encoder
     * @param authenticationManager - Initializes the Authentication Manager which authenticates an auth request
     * @param jwtTokenUtil - Initializes the JWT Token utility class
     * @param restTemplate - Initializes the Rest Template for microservice communication
     */
    @Autowired
    public AuthService(UserService userService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, RestTemplate restTemplate) {
        this.userService = userService;
        this.utility = new Utility();
        this.passwordEncoder = passwordEncoder;
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

        restTemplate.postForObject("http://account-service/api/v1/user", jsonString, String.class);
    }
}
