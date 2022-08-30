package com.mdonline.AccountService.Patient;

import com.mdonline.AccountService.User.GenderOption;
import com.mdonline.AccountService.User.User;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest()
class PatientRepositoryTest {
//    @Autowired
//    private PatientRepository patientRepository;
//
//    @BeforeEach
//    void setup() {
//
//        String date = "2000-02-20";
//        Date dt = Date.valueOf(date);
//        Patient patientOne = new Patient("email1@gmail.com", "pass",
//                "first", "last", "lasts", dt, 12312L, GenderOption.MALE);
//
//
//        patientRepository.save(patientOne);
//    }
//
//    @AfterEach
//    void tearDown() {
//        patientRepository.deleteAll();
//    }

}