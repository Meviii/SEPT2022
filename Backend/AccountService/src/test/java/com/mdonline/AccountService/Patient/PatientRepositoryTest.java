package com.mdonline.AccountService.Patient;

import com.mdonline.AccountService.User.User;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PatientRepositoryTest {
    @Autowired
    private PatientRepository patientRepository;

    @BeforeEach
    void setup() {

        String date = "2000-02-20";
        Date dt = Date.valueOf(date);
        Patient patientOne = new Patient("email2@gmail.com", "pass",
                "first", "last", "lasts"
                , dt,12312,123.0, "he", "asd");

        Patient patientTwo = new Patient("email1@gmail.com", "pass",
                "first", "last", "lasts"
                , dt,12312,123.0, "he", "asd");


        patientRepository.save(patientOne);
        patientRepository.save(patientTwo);
    }

    @AfterEach
    void tearDown(){
        patientRepository.deleteAll();
    }


    @Test
    void findById() {

        // when
        Optional<User> toCheck = Optional.ofNullable(patientRepository.findById(2));
        // then
        assertThat(toCheck).isNotNull();
    }

    @Test
    void findByEmail() {
        // when
        User toCheck = patientRepository.findByEmail("email2@gmail.com");

        // then
        assertThat(toCheck).isNotNull();
    }

    @Test
    void findAll() {
        List<Patient> allUsers = patientRepository.findAll();

        assertThat(allUsers).isNotEmpty();
    }

    @Test
    // works in real env
    void findAllByUserType(){

        List<Patient> users = patientRepository.findUsersByUserType("Patient");

        assertThat(users).isNotEmpty();
    }
}