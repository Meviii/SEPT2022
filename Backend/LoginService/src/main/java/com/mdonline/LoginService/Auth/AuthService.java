package com.mdonline.LoginService.Auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mdonline.LoginService.User.User;
import com.mdonline.LoginService.User.UserService;
import com.mdonline.LoginService.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserService userService;
    private Utility utility;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.utility = new Utility();
        this.passwordEncoder = passwordEncoder;
    }

    public boolean canAuthenticate(String jsonString) {

        boolean toReturn = false;

        try {
            User toValidate = utility.jsonStringToDoctorOrPatientByUserType(jsonString);
            User toCompare = userService.getUserByEmail(toValidate.getEmail());

            if (passwordEncoder.matches(toValidate.getPassword(), toCompare.getPassword())){
                toReturn = true;
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return toReturn;
    }
}
