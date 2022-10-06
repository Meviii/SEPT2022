package com.mdonline.LoginService.Service;

import com.mdonline.LoginService.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business logic of User URI endpoints and data handling.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class);

    /**
     * Main constructor for the User service.
     *
     * @param userRepository - Initializes global user repository
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        LOGGER.info("User service started.");
    }
}
