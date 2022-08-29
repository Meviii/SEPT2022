package com.mdonline.AccountService.User;

import com.mdonline.AccountService.Doctor.Doctor;
import com.mdonline.AccountService.Patient.Patient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        this.userService = new UserService(userRepository);
        String date = "2000-02-20";
        Date dt = Date.valueOf(date);
        User patientToTest = new Patient("email1@gmail.com", "pass",
                "first", "last", "lasts", dt, 12312L, GenderOption.MALE);

        User doctorToTest = new Doctor("email2@gmail.com", "pass",
                "first", "last", "lasts"
                , dt, 12321312L, GenderOption.MALE, "some profession");

        userRepository.save(patientToTest); // id of 1
        userRepository.save(doctorToTest); // id of 2
    }

    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    void getAllUsers() {
        userService.getAllUsers();
        verify(userRepository).findAll();
    }

    @Test
    void getUserById() {
        userService.getUserById(1);
        verify(userRepository).findById(1);
    }

    @Test
    void getUserByEmail() {
        userService.getUserByEmail("email1@gmail.com");
        verify(userRepository).findByEmail("email1@gmail.com");
    }

    @Test
    void updateUser() {
//        User u = userRepository.findByEmail("email1@gmail.com");
//        u.setId(u.getId());
//        u.setFirstName("hello");
//
//        userService.updateUser(u, u.getId());
//        verify(userRepository).save(u);
    }

    @Test
    void createUser() {
        String date = "2000-02-20";
        Date dt = Date.valueOf(date);
        User patientToTest = new Patient("email1@gmail.com", "pass",
                "first", "last", "lasts", dt, 12312L, GenderOption.MALE);

    }

    @Test
    void deleteUser() {
    }

}