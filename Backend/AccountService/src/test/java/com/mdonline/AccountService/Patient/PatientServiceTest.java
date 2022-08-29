package com.mdonline.AccountService.Patient;

import com.mdonline.AccountService.User.GenderOption;
import com.mdonline.AccountService.User.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

import java.sql.Date;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;
    private PatientService patientService;

    @BeforeEach
    void setUp() {
        patientService = new PatientService(patientRepository);

        String date = "2000-02-20";
        Date dt = Date.valueOf(date);
        Patient patientOne = new Patient("email2@gmail.com", "pass",
                "first", "last", "lasts"
                , dt,12312L, GenderOption.MALE, 123.0, 123123.0, "he", HealthStatus.COVID);

        Patient patientTwo = new Patient("email1@gmail.com", "pass",
                "first", "last", "lasts", dt, 12312L, GenderOption.MALE);

        patientRepository.save(patientOne);
        patientRepository.save(patientTwo);
    }

    @AfterEach
    void tearDown(){
        patientRepository.deleteAll();
    }

}