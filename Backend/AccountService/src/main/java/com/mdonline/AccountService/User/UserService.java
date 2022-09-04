package com.mdonline.AccountService.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mdonline.AccountService.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    Utility utility;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.utility = new Utility();
        this.passwordEncoder = passwordEncoder;
        System.out.println("User Service layer created.");

    }

    // Returns all patients if found, else, throws error
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id);

    }

    // Returns patient by EMAIL if found, else, throws error
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void updateUser(User user, long id){
        try{
            user.setId(id);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void createUser(String jsonString) throws JsonProcessingException {

        try {
            User userToCreate = utility.jsonStringToDoctorOrPatient(jsonString);
            if (userToCreate != null){
                userToCreate.setPassword(passwordEncoder.encode(userToCreate.getPassword()));
                userRepository.save(userToCreate);
            }
        }catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Unique value conflict.");
        }
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
