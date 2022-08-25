package com.mdonline.AccountService.Patient;


import com.mdonline.AccountService.Patient.Patient;
import com.mdonline.AccountService.Patient.PatientRepository;
import com.mdonline.AccountService.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service()
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        System.out.println("Patient Service layer created.");
    }

    // Returns patient by ID if found, else, throws error
    public Patient getPatientById(int id) {
        Patient patientToReturn = patientRepository.findPatientByPatientID(id);

        if (patientToReturn == null) {
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return patientToReturn;
    }

    // Returns all patients if found, else, throws error
    public List<Patient> getAllPatient() {
        List<Patient> patientsToReturn = patientRepository.findAll();

        if (patientsToReturn == null) {
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return patientsToReturn;
    }

    // Returns patient by EMAIL if found, else, throws error
    public Patient getPatientByEmail(String email) {
        Patient patientToReturn = patientRepository.findPatientByPatientEmail(email);

        if (patientToReturn == null) {
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return patientToReturn;
    }

    // Adds new patient
    public void addNewPatient(Patient patient) {

        if (patient.getPatientEmail() == "" || patient.getPatientPassword() == "" ||
                patient.getPatientPassword() == null || patient.getPatientEmail() == null ||
                patient.getPatientID() != null) {
            throw new CustomException("Incorrect key values", "603", HttpStatus.BAD_REQUEST);
        }

        patientRepository.save(patient);
    }

    // Updates patient
    public void updatePatient(int id, Map<String, String> patient){
        System.out.println(id);
        System.out.println(patient);
        Patient retrievedPatient = patientRepository.findPatientByPatientID(id);

        if (retrievedPatient.getPatientEmail() == null) {
            throw new CustomException("Patient not found", "601", HttpStatus.NOT_FOUND);
        }

        for (Map.Entry<String,String> entry : patient.entrySet()){
            if (entry.getKey() == "patientFirstName"){
                retrievedPatient.setPatientFirstName(entry.getValue());
            }else if (entry.getKey() == "patientCountry"){
                retrievedPatient.setPatientCountry(entry.getValue());
            }else if (entry.getKey() == "patientMiddleName"){
                retrievedPatient.setPatientMiddleName(entry.getValue());
            }else if (entry.getKey() == "patientLastName"){
                retrievedPatient.setPatientLastName(entry.getValue());
            }else if (entry.getKey() == "patientPhone"){
                retrievedPatient.setPatientPhone(Integer.parseInt(entry.getValue()));
            }else if (entry.getKey() == "patientBirth"){
                retrievedPatient.setPatientBirth(Date.valueOf(entry.getValue()));
            }else if (entry.getKey() == "patientStreetNo"){
                retrievedPatient.setPatientStreetNo(Integer.parseInt(entry.getValue()));
            }else if (entry.getKey() == "patientStreetName"){
                retrievedPatient.setPatientStreetName(entry.getValue());
            }else if (entry.getKey() == "patientCity"){
                retrievedPatient.setPatientCity(entry.getValue());
            }else if (entry.getKey() == "patientState"){
                retrievedPatient.setPatientState(entry.getValue());
            }else if (entry.getKey() == "patientPostCode"){
                retrievedPatient.setPatientPostCode(Integer.parseInt(entry.getValue()));
            }else if (entry.getKey() == "patientPassword"){
                retrievedPatient.setPatientPassword(entry.getValue());
            }else{
                throw new CustomException("Incorrect key values", "603", HttpStatus.BAD_REQUEST);
            }
        }
        patientRepository.save(retrievedPatient);
    }

}
