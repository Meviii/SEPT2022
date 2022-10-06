package com.mdonline.LoginService.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business logic of Patient URI endpoints and data handling.
 * Handled by User Service
 * This class will be used for specific patient related logic
 */
@Service
public class PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class);
    @Autowired
    public PatientService() {
        LOGGER.info("Patient service started.");
    }

}
