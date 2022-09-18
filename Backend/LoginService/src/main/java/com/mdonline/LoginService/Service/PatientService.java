package com.mdonline.LoginService.Service;

import com.mdonline.LoginService.Repository.PatientRepository;
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
