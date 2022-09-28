package com.mdonline.LoginService.Service;

import com.mdonline.LoginService.Model.User;
import com.mdonline.LoginService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business logic of User URI endpoints and data handling.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    /**
     * Main constructor for the User service.
     *
     * @param userRepository - Initializes global user repository
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Finds and returns a User by email if it is found in the datastore.
     *
     * @param email - User email
     * @Return - User OR null
     */
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
