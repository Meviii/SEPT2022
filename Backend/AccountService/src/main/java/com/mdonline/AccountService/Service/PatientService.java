package com.mdonline.AccountService.Service;

import com.mdonline.AccountService.Repository.PatientRepository;
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

    private PatientRepository patientRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        LOGGER.info("Patient service started.");
    }

}
