package com.mdonline.LoginService.Doctor;



import com.mdonline.LoginService.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/login/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    // Returns a doctor from specified ID
    @GetMapping(path="/get/id/{id}",consumes = "application/json", produces="application/json")
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
    @GetMapping(path="/get/all",consumes = "application/json", produces="application/json")
    public List<Doctor> getAllDoctors() {
        List<Doctor> toReturn;
        try {
            toReturn = doctorService.getAllDoctor();
        }catch (Exception e){
            throw new CustomException("Incorrect values", "602", HttpStatus.BAD_REQUEST);
        }
        return toReturn;
    }

    // Returns if doctor can login
    @GetMapping
    @ResponseBody
    public boolean canLogin(){
        return false;
    }

    // Returns a doctor from specified EMAIL
    @RequestMapping(value = "/get/email/{email}", method = RequestMethod.GET,consumes = "application/json", produces="application/json")
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
}
