package com.project.mdonline.controller;

import com.project.mdonline.model.Patient;
import com.project.mdonline.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/api/v1/patient")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    @GetMapping(path="/all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatient();
    }


    // Returns admin by email
    @RequestMapping("/{email}")
    @ResponseBody
    public Patient getPatientByEmail(@PathVariable String email) {
        return patientService.getPatientByEmail(email);
    }

}
