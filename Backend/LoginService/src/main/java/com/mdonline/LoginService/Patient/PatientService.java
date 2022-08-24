package com.mdonline.LoginService.Patient;


import com.mdonline.LoginService.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
        System.out.println("Patient Service layer created.");
    }

    // Returns patient by ID if found, else, throws error
    public Patient getPatientById(int id){
        Patient patientToReturn = patientRepository.findPatientByPatientID(id);

        if (patientToReturn == null){
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return patientToReturn;
    }

    // Returns all patients if found, else, throws error
    public List<Patient> getAllPatient(){
        List<Patient> patientsToReturn = patientRepository.findAll();

        if (patientsToReturn == null){
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return patientsToReturn;
    }

    // Returns patient by EMAIL if found, else, throws error
    public Patient getPatientByEmail(String email){
        Patient patientToReturn = patientRepository.findPatientByPatientEmail(email);

        if (patientToReturn == null){
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return patientToReturn;
    }

}
