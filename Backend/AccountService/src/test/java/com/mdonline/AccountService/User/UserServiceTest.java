package com.mdonline.AccountService.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mdonline.AccountService.Doctor.Doctor;
import com.mdonline.AccountService.Doctor.DoctorRepository;
import com.mdonline.AccountService.Patient.Patient;
import com.mdonline.AccountService.Patient.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private DoctorRepository doctorRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(patientRepository, doctorRepository);

        String date = "2000-02-20";
        Date dt = Date.valueOf(date);
        User patientToTest = new Patient("email2@gmail.com", "pass",
                "first", "last", "lasts"
                , dt,12312,123.0, "he", "asd");

        User doctorToTest = new Doctor("email1@gmail.com", "pass",
                "first", "last", "lasts"
                , dt, 12321312, "some profession");

        patientRepository.save(patientToTest); // id of 1
        doctorRepository.save(doctorToTest); // id of 2
    }

    @AfterEach
    void tearDown(){
        patientRepository.deleteAll();
    }


    @Test
    void getUserByIdForPatient() {
        userService.getUserById(1);
        verify(patientRepository).findById(1);
    }

    @Test
    void getUserByIdForDoctor() {
        userService.getUserById(2);
        verify(patientRepository).findById(2);
    }

    @Test
    void getAllUsers() {
        userService.getAllUsers();
        verify(patientRepository).findAll();
    }

    @Test
    void getUserByEmailForPatient(){
        userService.getUserByEmail("email2@gmail.com");
        verify(patientRepository).findByEmail("email2@gmail.com");
    }

    @Test
    void getUserByEmailForDoctor(){
        userService.getUserByEmail("email1@gmail.com");
        verify(doctorRepository).findByEmail("email1@gmail.com");
    }

    @Test
    void createUserForPatient() throws JsonProcessingException {
        String date = "2000-02-20";
        Date dt = Date.valueOf(date);
        User patient = new Patient("email4424@gmail.com", "pass",
                "first", "last", "lasts"
                , dt,12312,123.0, "he", "asd");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonOfObject = ow.writeValueAsString(patient);

        userService.createUser(jsonOfObject);
        verify(patientRepository).save(patient);
    }

    @Test
    void createUserForDoctor() throws JsonProcessingException {
        String date = "2000-02-20";
        Date dt = Date.valueOf(date);
        User doctor = new Doctor("email4424@gmail.com", "pass",
                "first", "last", "lasts"
                , dt,12312, "he");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonOfObject = ow.writeValueAsString(doctor);

        userService.createUser(jsonOfObject);
        verify(patientRepository).save(doctor);
    }

    @Test
    void updateUserForDoctor(){

    }

    @Test
    void updateUserForPatient(){

    }

    @Test
    void deleteUserForPatient(){
        String date = "2000-02-20";
        Date dt = Date.valueOf(date);
        User patient = new Patient("email422424@gmail.com", "pass",
                "first", "last", "lasts"
                , dt,12312,123.0, "he", "asd");
        patientRepository.save(patient);


        User u = userService.getUserByEmail("email422424@gmail.com");
        userService.deleteUser(u.getId());
        verify(patientRepository).delete((Patient)u);
    }

    @Test
    void deleteUserForDoctor(){
        String date = "2000-02-20";
        Date dt = Date.valueOf(date);
        User doctor = new Doctor("email4424@gmail.com", "pass",
                "first", "last", "lasts"
                , dt,12312, "he");
        doctorRepository.save(doctor);

        User u = userService.getUserByEmail("email4424@gmail.com");
        userService.deleteUser(u.getId());
        verify(doctorRepository).delete((Doctor)u);
    }
}