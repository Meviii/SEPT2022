package com.mdonline.AccountService.Doctor;


import com.mdonline.AccountService.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api/v1/doctor")
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    // Returns a doctor from specified ID, must not need JSON as consumer to allow /{email} to work
    @GetMapping(path="/{id}")
    @ResponseBody
    public Doctor getDoctorById(@PathVariable int id) {
        Doctor toReturn;
        try{
            toReturn = doctorService.getDoctorById(id);
        }catch (Exception e){
            throw new CustomException("Incorrect values", "602", HttpStatus.BAD_REQUEST);
        }
        return toReturn;
    }

    // Returns a list of ALL doctors
    @GetMapping(consumes = "application/json", produces="application/json")
    public List<Doctor> getAllDoctors() {
        List<Doctor> toReturn;
        try {
            toReturn = doctorService.getAllDoctor();
        }catch (Exception e){
            throw new CustomException("Incorrect values", "602", HttpStatus.BAD_REQUEST);
        }
        return toReturn;
    }

    // Returns a doctor from specified EMAIL
    @RequestMapping(value = "/{email}", method = RequestMethod.GET, consumes = "application/json", produces="application/json")
    @ResponseBody
    public Doctor getDoctorByEmail(@PathVariable String email) {
        Doctor toReturn;
        try {
            toReturn = doctorService.getDoctorByEmail(email);
        }catch (Exception e){
            throw new CustomException("Incorrect values", "602", HttpStatus.BAD_REQUEST);
        }
        return toReturn;
    }


    // Save specified doctor to database
    @PostMapping(path="/", consumes = "application/json", produces="application/json")
    public void addNewDoctor(@RequestBody Doctor doctor){
        try {
            doctorService.addNewDoctor(doctor);
        }catch (Exception e){
            throw new CustomException("Incorrect key values", "603", HttpStatus.BAD_REQUEST);
        }
    }

    // Update specified doctor
    @PutMapping(path="/update/{id}", consumes = "application/json", produces="application/json")
    public void updateDoctor(@RequestBody Map<String, String> doctor, @PathVariable int id){
        try {
            doctorService.updateDoctor(id, doctor);
        }catch (Exception e){
            throw new CustomException("Incorrect key or value types", "604", HttpStatus.BAD_REQUEST);
        }
    }
}
