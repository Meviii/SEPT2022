package com.mdonline.AccountService.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mdonline.AccountService.Exceptions.CustomException;
import com.mdonline.AccountService.Model.User.User;
import com.mdonline.AccountService.Service.UserService;
import com.mdonline.AccountService.Utility;
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
    private Utility utility;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
        this.utility = new Utility();

    }

    @GetMapping(produces="application/json")
    public List<User> getAllUsers() {
        List<User> toReturn;
        try {
            toReturn = userService.getAllUsers();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }
        return toReturn;
    }

    @GetMapping(path = "/{id}",produces="application/json")
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
    public ResponseEntity<String> updateUser(@RequestBody String jsonString, @PathVariable int id) {

        try {
            User toUpdate = utility.jsonStringToDoctorOrPatient(jsonString);
            if (toUpdate != null) {
                userService.updateUser(toUpdate, id);
            }else{
                return new ResponseEntity<>("Could not update", HttpStatus.NO_CONTENT);
            }
        } catch (MethodNotAllowedException e) {
            return new ResponseEntity<>("Incorrect Method", HttpStatus.METHOD_NOT_ALLOWED);
        } catch (Exception e) {
            return new ResponseEntity<>("User does not exist or incorrect format", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User updated.", HttpStatus.OK);
    }

    // Update specified patient
    @PostMapping(produces="application/json")
    public ResponseEntity<String> createUser(@RequestBody String jsonString) {
        try {
            try {
                userService.createUser(jsonString);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }catch (MethodNotAllowedException e){
            return new ResponseEntity<>("Incorrect Method", HttpStatus.METHOD_NOT_ALLOWED);
        }
        return new ResponseEntity<>("User added.", HttpStatus.CREATED);
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

    @DeleteMapping(path = "/")
    public ResponseEntity<String> deleteUser(){
        try {
            userService.deleteAll();
        }catch (MethodNotAllowedException e){
            return new ResponseEntity<>("Incorrect Method", HttpStatus.METHOD_NOT_ALLOWED);
        }catch (Exception e){
            return new ResponseEntity<>("User does not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("All Users deleted.", HttpStatus.OK);
    }

}
