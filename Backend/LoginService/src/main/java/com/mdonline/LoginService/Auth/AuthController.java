package com.mdonline.LoginService.Auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    private AuthService authService;


    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
        LOGGER.trace("Created Auth Controller");
    }

    @PostMapping("/")
    public ResponseEntity<?> auth(@RequestBody @Valid AuthRequest request){
        try{
            AuthResponse response = authService.canAuthenticate(request);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            LOGGER.trace("Bad Credentials: failed to auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e){
            LOGGER.error("Exception: failed to auth");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @PostMapping(value = "/register", consumes = "application/json", produces="application/json")
    public ResponseEntity<?> register(@RequestBody String jsonString){
        try{
            authService.register(jsonString);
        } catch (Exception e){
            LOGGER.error("Exception: failed to register: " + e);
            return new ResponseEntity<>("Couldn't register user", HttpStatus.EXPECTATION_FAILED);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
