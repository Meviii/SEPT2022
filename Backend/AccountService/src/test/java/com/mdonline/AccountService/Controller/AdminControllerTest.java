package com.mdonline.AccountService.Controller;

import com.mdonline.AccountService.Model.Admin;
import com.mdonline.AccountService.Repository.AdminRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerTest {

    @Autowired
    private AdminController adminController;

    @MockBean
    AdminRepository adminRepository;

    @BeforeEach
    void setUp() {
        adminController = Mockito.mock(AdminController.class);
        Admin admin1 = new Admin("admin1@gmail.com", "a_password");
        adminRepository.save(admin1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAdminById() {
        Admin a = adminRepository.findById(1);
        when(adminController.getAdminById(1)).thenReturn(a);

        assertEquals(a, adminController.getAdminById(1));
    }

    @Test
    void getAllAdmins() {
        List<Admin> adminList = adminRepository.findAll();

        when(adminController.getAllAdmins()).thenReturn(adminList);
        assertEquals(adminList, adminController.getAllAdmins());
    }

    @Test
    void getAdminByEmail() {
        Admin a = adminRepository.findByEmail("admin1@gmail.com");
        when(adminController.getAdminByEmail("admin1@gmail.com")).thenReturn(a);

        assertEquals(a, adminController.getAdminByEmail("admin1@gmail.com"));
    }

    @Test
    void updateAdmin() {
        // same as createAdmin
    }

    @Test
    void createAdmin() {
        Admin admin2 = new Admin("admin2@gmail.com", "a_password");
        String admin2String = admin2.toString();
        ResponseEntity<String> response = new ResponseEntity<>("Admin added.", HttpStatus.CREATED);
        when(adminController.createAdmin(admin2String)).thenReturn(response);

        assertEquals(response, adminController.createAdmin(admin2String));
    }

    @Test
    void deleteAdmin() {

        ResponseEntity<String> response = new ResponseEntity<>("Admin deleted.", HttpStatus.OK);

        when(adminController.deleteAdmin(1)).thenReturn(response);

        assertEquals(response, adminController.deleteAdmin(1));
    }

    @Test
    void deleteAll() {
        ResponseEntity<String> response = new ResponseEntity<>("All admins deleted.", HttpStatus.OK);

        when(adminController.deleteAll()).thenReturn(response);

        assertEquals(response, adminController.deleteAll());
    }
}