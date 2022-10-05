package com.mdonline.AccountService.Service;

import com.mdonline.AccountService.Repository.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business logic of Doctor URI endpoints and data handling.
 * Handled by User Service
 * This class will be used for specific doctor related logic
 */
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        LOGGER.info("Doctor service started.");
    }
}
