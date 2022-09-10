package com.mdonline.AccountService.Service;

import com.mdonline.AccountService.Model.User.GenderOption;
import com.mdonline.AccountService.Model.User.HealthStatus;
import com.mdonline.AccountService.Model.User.Patient;
import com.mdonline.AccountService.Model.User.User;
import com.mdonline.AccountService.Repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, passwordEncoder);

        Date date = new Date(-1);
        User patient = new Patient("new@gmail.com", "password", "Name", "Middle", "Last",
                date, 042222312L, GenderOption.MALE, 120.0, 120.0, "Healthy", HealthStatus.GOOD);

        userRepository.save(patient);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUserById() {
        userService.getUserById(1);
        verify(userRepository).findById(1);
    }

    @Test
    void getAllUser() {
        userService.getAllUsers();
        verify(userRepository).findAll();
    }

    @Test
    void getUserByEmail() {
        userService.getUserByEmail("new@gmail.com");
        verify(userRepository).findByEmail("new@gmail.com");
    }

    @Test
    void deleteUser() {
        userService.deleteUser(1);
        verify(userRepository).deleteById(1);
    }

    @Test
    void deleteAll() {
        userService.deleteAll();
        verify(userRepository).deleteAll();
    }
}