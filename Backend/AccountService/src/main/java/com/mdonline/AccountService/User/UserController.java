package com.mdonline.AccountService.User;

import com.mdonline.AccountService.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        List<User> toReturn;
        try {
            toReturn = userService.getAllUsers();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }
        return toReturn;
    }

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable int id) {
        User toReturn = userService.getUserById(id);

        if (toReturn == null){
            throw new CustomException("User does not exist", HttpStatus.NOT_FOUND);
        }

        return toReturn;
    }

    @GetMapping(path="/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        User toReturn;
        try {
            toReturn = userService.getUserByEmail(email);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }
        return toReturn;
    }

    @PutMapping(path="/{id}", consumes = "application/json", produces="application/json")
    public ResponseEntity<String> updateUser(@RequestBody String user, @PathVariable int id){
        try {
            userService.updateUser(user, id);
        }catch (MethodNotAllowedException e){
            return new ResponseEntity<>("Incorrect Method", HttpStatus.METHOD_NOT_ALLOWED);
        }catch (Exception e){
            return new ResponseEntity<>("User does not exist or incorrect format", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User updated.", HttpStatus.OK);
    }

    // Update specified patient
    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity<String> createUser(@RequestBody String user) {
        try {
            userService.createUser(user);
        }catch (MethodNotAllowedException e){
            return new ResponseEntity<>("Incorrect Method", HttpStatus.METHOD_NOT_ALLOWED);
        }catch (Exception e){
            return new ResponseEntity<>("Incorrect Format", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User added.", HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        try {
            userService.deleteUser(id);
        }catch (MethodNotAllowedException e){
            return new ResponseEntity<>("Incorrect Method", HttpStatus.METHOD_NOT_ALLOWED);
        }catch (Exception e){
            return new ResponseEntity<>("User does not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("User deleted.", HttpStatus.OK);
    }
}
