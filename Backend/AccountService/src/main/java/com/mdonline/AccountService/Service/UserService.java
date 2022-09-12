package com.mdonline.AccountService.Service;

import com.mdonline.AccountService.Model.User.User;
import com.mdonline.AccountService.Model.User.UserList;
import com.mdonline.AccountService.Repository.UserRepository;
import com.mdonline.AccountService.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    public UserList getAllUsers() {
        UserList userList = new UserList(userRepository.findAll());
        return userList;
    }

    public User getUserById(long id){
        return userRepository.findById(id);

    }

    // Returns patient by EMAIL if found, else, throws error
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Boolean updateUser(User user, long id){
        Boolean isUpdated = true;

        try{
            user.setId(id);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }catch (Exception e){
            isUpdated = false;
        }
        return isUpdated;

    }

    public Boolean createUser(User user) {
        Boolean isCreated = true;

        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);

        }catch (Exception e){
            isCreated = false;
        }
        return isCreated;
    }

    public Boolean deleteUser(long id){
        Boolean isDeleted = true;
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            isDeleted = false;
        }
        return isDeleted;
    }

    public Boolean deleteAll() {
        Boolean isDeleted = true;
        try {
            userRepository.deleteAll();
        }catch (Exception e){
            isDeleted = false;
        }
        return isDeleted;
    }
}
