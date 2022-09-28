package com.mdonline.AccountService.Service;

import com.mdonline.AccountService.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business logic of Patient URI endpoints and data handling.
 * Handled by User Service
 *
 * This class will be used for specific patient related logic
 */
@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        System.out.println("Patient Service layer created.");
    }

}
