package com.mdonline.LoginService.Controller;

import com.mdonline.LoginService.Model.Auth.AuthRequest;
import com.mdonline.LoginService.Model.Auth.AuthResponse;
import com.mdonline.LoginService.Service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * WEB Endpoint controller/ URI Controller
 */
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    private AuthService authService;

    /**
     * Main constructor for the auth controller with auth service
     * @param authService
     */
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
        LOGGER.trace("Created Auth Controller");
    }

    /**
     * Returns a response depending on if the user has been authenticated
     *
     * @param request - The user credentials to be authenticated
     */
    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<?> auth(@RequestBody @Valid AuthRequest request){
        try{
            AuthResponse response = authService.canAuthenticate(request);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            LOGGER.info("Bad Credentials: failed to auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e){
            LOGGER.error("Exception: failed to auth");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    /**
     * Returns a response depending on if the user has been registered
     *
     * @param jsonString - Json string of user payload
     */
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
