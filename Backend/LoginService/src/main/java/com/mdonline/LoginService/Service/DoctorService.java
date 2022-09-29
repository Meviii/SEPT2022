package com.mdonline.LoginService.Service;

import com.mdonline.LoginService.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business logic of Doctor URI endpoints and data handling.
 * Handled by User Service
 *
 * This class will be used for specific doctor related logic
 */
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        System.out.println("Doctor Service layer created.");
    }
}
