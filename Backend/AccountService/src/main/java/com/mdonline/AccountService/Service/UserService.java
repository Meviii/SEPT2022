package com.mdonline.AccountService.Service;

import com.mdonline.AccountService.Model.User.User;
import com.mdonline.AccountService.Model.User.UserList;
import com.mdonline.AccountService.Repository.UserRepository;
import com.mdonline.AccountService.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Business logic of User URI endpoints and data handling.
 */
@Service
public class UserService {

    private UserRepository userRepository;
    Utility utility;
    private PasswordEncoder passwordEncoder;

    /**
     * Main constructor for the User service.
     *
     * @param userRepository - Initializes global user repository
     * @param passwordEncoder - Initializes global Bcrypt password encoder
     */
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.utility = new Utility();
        this.passwordEncoder = passwordEncoder;
        System.out.println("User Service layer created.");
    }

    /**
     * Finds and returns a UserList of all users found in the datastore.
     *
     * @Return - UserList
     */
    public UserList getAllUsers() {
        UserList userList = new UserList(userRepository.findAll());
        return userList;
    }

    /**
     * Finds and returns a User by id if it is found in the datastore.
     *
     * @param id - User id
     * @Return - User OR null
     */
    public User getUserById(long id){
        return userRepository.findById(id);

    }

    /**
     * Finds and returns a User by email if it is found in the datastore.
     *
     * @param email - User email
     * @Return - User OR null
     */
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Finds and updates a User by given User object and id if id is found in the datastore.
     *
     * @param user - User object
     * @param id - User id
     *
     * @Return - Boolean value representing if user has been updated
     */
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

    /**
     * Creates a new User and saves into datastore.
     *
     * @param user - User object to save
     *
     * @Return - Boolean value representing if user has been created
     */
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

    /**
     * Deletes a User if id exists in datastore
     *
     * @param id - User id to delete
     *
     * @Return - Boolean value representing if user has been deleted
     */
    public Boolean deleteUser(long id){
        Boolean isDeleted = true;
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            isDeleted = false;
        }
        return isDeleted;
    }

    /**
     * Deletes all Users which exist in the datastore
     *
     * @Return - Boolean value representing if users have been deleted
     */
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
