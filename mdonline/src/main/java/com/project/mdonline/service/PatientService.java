package com.project.mdonline.service;


import com.project.mdonline.model.Patient;
import com.project.mdonline.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
        System.out.println("Patient Service layer created.");
    }

    public Patient getPatientById(int id){


        return patientRepository.findPatientByID(id);
    }

    public List<Patient> getAllPatient(){
        return patientRepository.findAllPatient();
    }

    public Patient getPatientByEmail(String email){
        return patientRepository.findPatientByEmail(email);
    }
}
