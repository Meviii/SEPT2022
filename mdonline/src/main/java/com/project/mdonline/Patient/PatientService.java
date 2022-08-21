package com.project.mdonline.Patient;


import com.project.mdonline.Exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
            throw new EntityNotFoundException("Entity not found", "601");
        }

        return patientToReturn;
    }

    // Returns all patients if found, else, throws error
    public List<Patient> getAllPatient(){
        List<Patient> patientsToReturn = patientRepository.findAll();

        if (patientsToReturn == null){
            throw new EntityNotFoundException("Entity not found", "601");
        }

        return patientsToReturn;
    }

    // Returns patient by EMAIL if found, else, throws error
    public Patient getPatientByEmail(String email){
        Patient patientToReturn = patientRepository.findPatientByPatientEmail(email);

        if (patientToReturn == null){
            throw new EntityNotFoundException("Entity not found", "601");
        }

        return patientToReturn;
    }

}
