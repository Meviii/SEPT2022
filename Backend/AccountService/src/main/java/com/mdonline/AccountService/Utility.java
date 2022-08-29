package com.mdonline.AccountService;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mdonline.AccountService.Admin.Admin;
import com.mdonline.AccountService.Doctor.Doctor;
import com.mdonline.AccountService.Patient.Patient;
import com.mdonline.AccountService.User.User;

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

    // This function returns the User object of the received json string.
    public Admin jsonStringToAdmin(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Admin toReturn = mapper.readValue(jsonString, Admin.class);

        return toReturn;
    }

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
