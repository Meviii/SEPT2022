package com.mdonline.AccountService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdonline.AccountService.Model.User.Doctor;
import com.mdonline.AccountService.Model.User.Patient;
import com.mdonline.AccountService.Model.User.User;

/**
 * This is a utility class designed for clean code by eliminating code redundancy and confusion
 * Designed to hold utility functions including String de/serialization, parsing etc.
 */
public class Utility {


    // This function returns the User(Doctor or Patient) object of the received json string.
    public User jsonStringToDoctorOrPatient(String jsonString) throws JsonProcessingException {
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

    // Checks to see if received json string is of specified user type
    public boolean checkUserTypeFromJsonString(String jsonString, String userType) {
        String stringToCheck = String.format("\"usertype\": \"%s\"", userType);

        return jsonString.toLowerCase().contains(stringToCheck.toLowerCase());
    }

}
