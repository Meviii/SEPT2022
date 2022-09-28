package com.mdonline.AccountService.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mdonline.AccountService.Model.User.*;
import com.mdonline.AccountService.Repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() throws ParseException {
        userController = Mockito.mock(UserController.class);
        Date date = new Date(-1);

        User patient = new Patient("email@gmail.com", "password", "Name", "Middle", "Last",
                date, 042312L, GenderOption.MALE, 120.0, 120.0, "Healthy", HealthStatus.GOOD);
        userRepository.save(patient);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllUsers() {
        List<User> users = userRepository.findAll();
        UserList userList = new UserList(users);
        when(userController.getAllUsers()).thenReturn(userList);
        assertEquals(userList, userController.getAllUsers());
    }

    @Test
    void getUserById() {
        User a = userRepository.findById(1);
        when(userController.getUserById(1)).thenReturn(a);

        assertEquals(a, userController.getUserById(1));
    }

    @Test
    void getUserByEmail() {
        User a = userRepository.findByEmail("email@gmail.com");
        when(userController.getUserByEmail("email@gmail.com")).thenReturn(a);

        assertEquals(a, userController.getUserByEmail("email@gmail.com"));
    }

    @Test
    void updateUser() {
    }

    @Test
    void createUser() throws JsonProcessingException {
        Date date = new Date(-1);

        User patient = new Patient("email@gmail.com", "password", "Name", "Middle", "Last",
                date, 042312L, GenderOption.MALE, 120.0, 120.0, "Healthy", HealthStatus.GOOD);


        String user2String = patient.toString();
        ResponseEntity<String> response = new ResponseEntity<>("User added.", HttpStatus.CREATED);
        when(userController.createUser(user2String)).thenReturn(response);

        assertEquals(response, userController.createUser(user2String));
    }

    @Test
    void deleteUser() {
        ResponseEntity<String> response = new ResponseEntity<>("User deleted.", HttpStatus.OK);

        when(userController.deleteUser(1)).thenReturn(response);

        assertEquals(response, userController.deleteUser(1));
    }

}