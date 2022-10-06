package com.mdonline.AccountService.Service;

import com.mdonline.AccountService.Model.User.User;
import com.mdonline.AccountService.Model.User.UserList;
import com.mdonline.AccountService.Repository.UserRepository;
import com.mdonline.AccountService.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Business logic of User URI endpoints and data handling.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    Utility utility;
    private final PasswordEncoder passwordEncoder;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

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
        LOGGER.info("User service started.");
    }

    /**
     * Finds and returns a UserList of all users found in the datastore.
     *
     * @Return - UserList
     */
    public UserList getAllUsers() {
        LOGGER.info("Getting all users.");
        return new UserList(userRepository.findAll());
    }

    /**
     * Finds and returns a User by id if it is found in the datastore.
     *
     * @param id - User id
     * @Return - User OR null
     */
    public User getUserById(long id){
        LOGGER.info("Getting user with ID: " + id);
        return userRepository.findById(id);

    }

    /**
     * Finds and returns a User by email if it is found in the datastore.
     *
     * @param email - User email
     * @Return - User OR null
     */
    public User getUserByEmail(String email) {
        LOGGER.info("Getting user with Email: " + email);
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
        boolean isUpdated = true;
        LOGGER.info("Updating user with ID: " + id);
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
        boolean isCreated = true;
        LOGGER.info("Creating user.");
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
        LOGGER.info("Deleting user with ID: " + id);
        boolean isDeleted = true;
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
        LOGGER.info("Deleting all users.");
        boolean isDeleted = true;
        try {
            userRepository.deleteAll();
        }catch (Exception e){
            isDeleted = false;
        }
        return isDeleted;
    }
}
