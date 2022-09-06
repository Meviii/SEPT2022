package com.mdonline.LoginService.Auth;

import com.mdonline.LoginService.Jwt.JwtTokenUtil;
import com.mdonline.LoginService.User.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    private AuthService authService;
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthController(AuthService authService, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        LOGGER.trace("Created Auth Controller");
    }

    @PostMapping("/")
    public ResponseEntity<?> auth(@RequestBody @Valid AuthRequest request){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

            User user = (User) authentication.getPrincipal();

            String accessToken = jwtTokenUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);

            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {
            LOGGER.trace("Bad Credentials: failed to auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e){
            LOGGER.error("Exception: failed to auth");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }

    }

    @GetMapping(value="/admin")
    public String admin(){
        return ("<h1>Welcome Admin</h1>");
    }

    @GetMapping(value="/user")
    public String user(){
        return ("Welcome User");
    }

    @GetMapping(value="/home")
    public String home(){
        return ("<h1>Welcome</h1>");
    }
}
