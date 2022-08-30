package com.mdonline.AccountService.User;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdonline.AccountService.Address.Address;
import com.mdonline.AccountService.Doctor.Doctor;
import com.mdonline.AccountService.Doctor.DoctorRepository;
import com.mdonline.AccountService.Exceptions.CustomException;
import com.mdonline.AccountService.Patient.Patient;
import com.mdonline.AccountService.Patient.PatientRepository;
import com.mdonline.AccountService.Utility;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private UserRepository userRepository;
    Utility utility;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.utility = new Utility();
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
            userRepository.save(user);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void createUser(String jsonString) throws JsonProcessingException {

        try {
            User userToCreate = utility.jsonStringToDoctorOrPatient(jsonString);
            if (userToCreate != null){
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
