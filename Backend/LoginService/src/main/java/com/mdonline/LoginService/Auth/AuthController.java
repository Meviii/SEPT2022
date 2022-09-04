package com.mdonline.LoginService.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping(value = "/",consumes = "application/json", produces="application/json")
    @ResponseBody
    public ResponseEntity<String> canAuth(@RequestBody String jsonString){
        ResponseEntity<String> toReturn = new ResponseEntity("User can not Authenticate", HttpStatus.OK);
        try {
            if (authService.canAuthenticate(jsonString)) {
                toReturn = new ResponseEntity<>("User can Authenticate", HttpStatus.OK);
            }
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }

        return toReturn;
    }

    @GetMapping(value="/admin")
    public String admin(){
        return ("<h1>Welcome Admin</h1>");
    }

    @GetMapping(value="/user")
    public String user(){
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping(value="/home")
    public String home(){
        return ("<h1>Welcome</h1>");
    }
}
