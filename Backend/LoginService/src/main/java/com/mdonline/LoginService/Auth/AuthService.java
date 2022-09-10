package com.mdonline.LoginService.Auth;

import com.mdonline.LoginService.Jwt.JwtTokenUtil;
import com.mdonline.LoginService.User.User;
import com.mdonline.LoginService.User.UserService;
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

    private UserService userService;
    private Utility utility;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private RestTemplate restTemplate;

    @Autowired
    public AuthService(UserService userService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, RestTemplate restTemplate) {
        this.userService = userService;
        this.utility = new Utility();
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.restTemplate = restTemplate;
    }

    public AuthResponse canAuthenticate(AuthRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = (User) authentication.getPrincipal();

        String accessToken = jwtTokenUtil.generateAccessToken(user);
        AuthResponse response = new AuthResponse(user.getEmail(), accessToken);

        return response;
    }

    public void register(String jsonString) {

        restTemplate.postForObject("http://account-service/api/v1/user", jsonString, String.class);

    }
}
