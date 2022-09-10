package com.mdonline.AccountService.Service;

import com.mdonline.AccountService.Model.Admin;
import com.mdonline.AccountService.Repository.AdminRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;
    private AdminService adminService;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        adminService = new AdminService(adminRepository, passwordEncoder);

        Admin admin1 = new Admin("admin1@gmail.com", "a_password");
        adminRepository.save(admin1);
    }

    @AfterEach
    void tearDown(){
    }

    @Test
    void getAdminById() {
        adminService.getAdminById(1);
        verify(adminRepository).findById(1);
    }

    @Test
    void getAllAdmin() {
        adminService.getAllAdmin();
        verify(adminRepository).findAll();
    }

    @Test
    void getAdminByEmail() {
        adminService.getAdminByEmail("admin1@gmail.com");
        verify(adminRepository).findByEmail("admin1@gmail.com");
    }

    @Test
    void deleteAdmin() {
        adminService.deleteAdmin(1);
        verify(adminRepository).delete(adminRepository.findById(1));
    }

    @Test
    void deleteAll() {
        adminService.deleteAll();
        verify(adminRepository).deleteAll();
    }
}