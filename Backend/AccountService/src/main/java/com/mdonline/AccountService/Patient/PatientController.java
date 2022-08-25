package com.mdonline.AccountService.Patient;

import com.mdonline.AccountService.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path="/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    // Returns a patient from specified ID, must not need JSON as consumer to allow /{email} to work
    @GetMapping(path="/{id}")
    @ResponseBody
    public Patient getPatientById(@PathVariable int id) {
         Patient toReturn;
        try{
            toReturn = patientService.getPatientById(id);
        }catch (Exception e){
            throw new CustomException("Incorrect values", "602", HttpStatus.BAD_REQUEST);
        }
        return toReturn;
    }

    // Returns a list of ALL patients
    @GetMapping(consumes = "application/json", produces="application/json")
    public List<Patient> getAllPatients() {
        List<Patient> toReturn;
        try {
            toReturn = patientService.getAllPatient();
        }catch (Exception e){
            throw new CustomException("Incorrect values", "602", HttpStatus.BAD_REQUEST);
        }
        return toReturn;
    }

    // Returns a patient from specified EMAIL
//    @RequestMapping(path = "/{email}", method = RequestMethod.GET, consumes = "application/json", produces="application/json")
    @GetMapping(path="/{email}", consumes = "application/json", produces="application/json")
    @ResponseBody
    public Patient getPatientByEmail(@PathVariable String email) {
         Patient toReturn;
        try {
            toReturn = patientService.getPatientByEmail(email);
        }catch (Exception e){
            throw new CustomException("Incorrect values", "602", HttpStatus.BAD_REQUEST);
        }
        return toReturn;
    }

    // Save specified patient to database
    @PostMapping(path="/", consumes = "application/json", produces="application/json")
    public void addNewPatient(@RequestBody Patient patient){
        try {
            patientService.addNewPatient(patient);
        }catch (Exception e){
            throw new CustomException("Incorrect key values", "603", HttpStatus.BAD_REQUEST);
        }
    }

    // Update specified patient
    @PutMapping(path="/update/{id}", consumes = "application/json", produces="application/json")
    public void updatePatient(@RequestBody Map<String, String> patient, @PathVariable int id){
        try {
            patientService.updatePatient(id, patient);
        }catch (Exception e){
            throw new CustomException("Incorrect key or value types", "604", HttpStatus.BAD_REQUEST);
        }
    }

}
