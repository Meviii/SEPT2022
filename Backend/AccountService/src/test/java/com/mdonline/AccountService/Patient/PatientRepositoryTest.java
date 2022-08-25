package com.mdonline.AccountService.Patient;

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

    @Test
    void itShouldFindById() {
        // given
        String date = "2000-02-20";
        Date dt = Date.valueOf(date);
        Patient patient = new Patient("name", "pass",
                "first", "last", "lasts"
                , dt,123.0, "he", "asd");
        patient.setPhone(123);

        patientRepository.save(patient);
        // when
        Optional<Patient> toCheck = patientRepository.findById(patient.getId());
        // then
        assertThat(toCheck).isNotEmpty();
    }

    @Test
    void itShouldFindByEmail(){
        // given
        String date = "2000-02-20";
        Date dt = Date.valueOf(date);
        Patient patient = new Patient("name", "pass",
                "first", "last", "lasts"
                , dt,123.0, "he", "asd");
        patient.setPhone(123);

        patientRepository.save(patient);
        // when
        Patient toCheck = patientRepository.findByEmail(patient.getEmail());
        // then
        assertThat(toCheck).isNotNull();
    }

    @Test
    void itShouldFindAll(){
        // given
        String date = "2000-02-20";
        Date dt = Date.valueOf(date);
        Patient patient = new Patient("name", "pass",
                "first", "last", "lasts"
                , dt,123.0, "he", "asd");
        patient.setPhone(123);

        Patient patientTwo = new Patient("nametwo", "pass",
                "first", "last", "lasts"
                , dt,123.0, "he", "asd");
        patientTwo.setPhone(123);

        patientRepository.save(patient);
        patientRepository.save(patientTwo);
        // when
        List<Patient> toCheck = patientRepository.findAll();
        // then
        assertThat(toCheck).isNotEmpty();
    }
}