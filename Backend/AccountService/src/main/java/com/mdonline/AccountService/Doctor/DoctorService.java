package com.mdonline.AccountService.Doctor;

import com.mdonline.AccountService.Exceptions.CustomException;
import com.mdonline.AccountService.Patient.Patient;
import com.mdonline.AccountService.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        System.out.println("Doctor Service layer created.");


    }

}
