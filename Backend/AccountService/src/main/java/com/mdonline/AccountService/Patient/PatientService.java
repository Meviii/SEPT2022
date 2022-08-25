package com.mdonline.AccountService.Patient;



import com.mdonline.AccountService.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        System.out.println("Patient Service layer created.");

//        String date = "20/02/2000";
//        Date dt = Date.valueOf(date);
//
//        Patient patient = new Patient("name", "pass", "first", "last", "lasts", dt,123, "he", "asd");
//        patientRepository.save(patient);
    }

    // Returns patient by ID if found, else, throws error
    public Patient getPatientById(int id) {
        Patient patientToReturn = patientRepository.findById(id);

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
        Patient patientToReturn = patientRepository.findByEmail(email);

        if (patientToReturn == null) {
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return patientToReturn;
    }

    // Adds new patient
    public void addNewPatient(Patient patient) {

        if (patient.getEmail() == "" || patient.getPassword() == "" ||
                patient.getPassword() == null || patient.getEmail() == null ||
                patient.getId() != null) {
            throw new CustomException("Incorrect key values", "603", HttpStatus.BAD_REQUEST);
        }

        patientRepository.save(patient);
    }

    // Updates patient
    public void updatePatient(int id, Map<String, String> patient){
        System.out.println(id);
        System.out.println(patient);
        Patient retrievedPatient = patientRepository.findById(id);

        if (retrievedPatient.getEmail() == null) {
            throw new CustomException("Patient not found", "601", HttpStatus.NOT_FOUND);
        }

        for (Map.Entry<String,String> entry : patient.entrySet()){
            if (entry.getKey() == "patientFirstName"){
                retrievedPatient.setFirstName(entry.getValue());
            }else if (entry.getKey() == "patientCountry"){
                retrievedPatient.setCountry(entry.getValue());
            }else if (entry.getKey() == "patientMiddleName"){
                retrievedPatient.setMiddleName(entry.getValue());
            }else if (entry.getKey() == "patientLastName"){
                retrievedPatient.setLastName(entry.getValue());
            }else if (entry.getKey() == "patientPhone"){
                retrievedPatient.setPhone(Integer.parseInt(entry.getValue()));
            }else if (entry.getKey() == "patientBirth"){
                retrievedPatient.setBirth(Date.valueOf(entry.getValue()));
            }else if (entry.getKey() == "patientStreetNo"){
                retrievedPatient.setStreetNo(Integer.parseInt(entry.getValue()));
            }else if (entry.getKey() == "patientStreetName"){
                retrievedPatient.setStreetName(entry.getValue());
            }else if (entry.getKey() == "patientCity"){
                retrievedPatient.setCity(entry.getValue());
            }else if (entry.getKey() == "patientState"){
                retrievedPatient.setState(entry.getValue());
            }else if (entry.getKey() == "patientPostCode"){
                retrievedPatient.setPostCode(Integer.parseInt(entry.getValue()));
            }else if (entry.getKey() == "patientPassword"){
                retrievedPatient.setPassword(entry.getValue());
            }else{
                throw new CustomException("Incorrect key values", "603", HttpStatus.BAD_REQUEST);
            }
        }
        patientRepository.save(retrievedPatient);
    }

}
