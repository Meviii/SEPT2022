package com.mdonline.LoginService.Doctor;


import com.mdonline.LoginService.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        System.out.println("Doctor Service layer created.");
    }

    // Returns doctor by ID if found, else, throws error
    public Doctor getDoctorById(int id) {
        Doctor doctorToReturn = doctorRepository.findDoctorByDoctorID(id);

        if (doctorToReturn == null) {
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return doctorToReturn;
    }

    // Returns all doctors if found, else, throws error
    public List<Doctor> getAllDoctor() {
        List<Doctor> doctorsToReturn = doctorRepository.findAll();

        if (doctorsToReturn == null) {
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return doctorsToReturn;
    }

    // Returns doctor by EMAIL if found, else, throws error
    public Doctor getDoctorByEmail(String email) {
        Doctor doctorToReturn = doctorRepository.findDoctorByDoctorEmail(email);

        if (doctorToReturn == null) {
            throw new CustomException("Entity not found", "601", HttpStatus.NOT_FOUND);
        }

        return doctorToReturn;
    }
    
}
