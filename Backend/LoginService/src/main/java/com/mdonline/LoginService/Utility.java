package com.mdonline.LoginService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdonline.LoginService.Doctor.Doctor;
import com.mdonline.LoginService.Patient.Patient;
import com.mdonline.LoginService.User.User;
import org.springframework.stereotype.Component;

@Component
public class Utility {


    // This function returns the User(Doctor or Patient) object of the received json string.
    public User jsonStringToDoctorOrPatientByUserType(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.enable(DeserializationFeature.USE_LONG_FOR_INTS);
        mapper.enable(JsonReadFeature.ALLOW_LEADING_ZEROS_FOR_NUMBERS.mappedFeature());

        User toReturn;
        if (checkUserTypeFromJsonString(jsonString, "Doctor")) {
            toReturn = mapper.readValue(jsonString, Doctor.class);
        } else if (checkUserTypeFromJsonString(jsonString, "Patient")) {
            toReturn = mapper.readValue(jsonString, Patient.class);
        } else {
            return null;
        }

        return toReturn;
    }

    // This function returns the User object of the received json string.
//    public Admin jsonStringToAdmin(String jsonString) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//        Admin toReturn = mapper.readValue(jsonString, Admin.class);
//
//        return toReturn;
//    }

    // Checks to see if received json string is of specified user type
    public boolean checkUserTypeFromJsonString(String jsonString, String userType) {
        String stringToCheck = String.format("\"usertype\": \"%s\"", userType);
        boolean toReturn = false;

        if (jsonString.toLowerCase().contains(stringToCheck.toLowerCase())) {
            toReturn = true;
        }

        return toReturn;
    }

}
