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

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/users")
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
        List<User> toReturn = userService.getAllUsers();

        if (toReturn.isEmpty()){
            throw new CustomException("No users currently.", HttpStatus.NOT_FOUND);
        }
        return toReturn;
    }

    @GetMapping(path = "/{id}",produces="application/json")
    @ResponseBody
    public User getUserById(@PathVariable long id) {
        User toReturn = userService.getUserById(id);

        if (toReturn == null){
            throw new CustomException("User doesn't not exist", HttpStatus.NOT_FOUND);
        }

        return toReturn;
    }

    @GetMapping(path="email/{email}")
    @ResponseBody
    public User getUserByEmail(@PathVariable String email) {
        User toReturn = userService.getUserByEmail(email);

        if (toReturn == null){
            throw new CustomException("User doesn't exist", HttpStatus.NOT_FOUND);
        }

        return toReturn;
    }

    @PutMapping(path="/{id}", consumes = "application/json", produces="application/json")
    public ResponseEntity<String> updateUser(@RequestBody String jsonString, @PathVariable long id) throws JsonProcessingException {

        User toUpdate = utility.jsonStringToDoctorOrPatient(jsonString);
        Boolean isUpdated = userService.updateUser(toUpdate, id);

        if (isUpdated == false){
            throw new CustomException("Couldn't update user", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User updated.", HttpStatus.OK);
    }

    // Update specified patient
    @PostMapping(produces="application/json")
    public ResponseEntity<String> createUser(@RequestBody String jsonString) throws JsonProcessingException {
        User toUpdate = utility.jsonStringToDoctorOrPatient(jsonString);
        Boolean isCreated = userService.createUser(toUpdate);

        if (isCreated == false){
            throw new CustomException("Couldn't create user", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User created.", HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){

        Boolean isDeleted = userService.deleteUser(id);

        if (isDeleted == false){
            throw new CustomException("Couldn't delete user", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User deleted.", HttpStatus.OK);
    }

    @DeleteMapping(path = "/")
    public ResponseEntity<String> deleteUser(){
        Boolean isDeleted = userService.deleteAll();

        if (isDeleted == false){
            throw new CustomException("Couldn't delete users", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("All Users deleted.", HttpStatus.OK);
    }

}
