package com.mdonline.AccountService.Repository;

import com.mdonline.AccountService.Model.Admin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepository;

    @BeforeEach
    void setUp() {
        Admin admin1 = new Admin("admin1@gmail.com", "a_password");
        Admin admin2 = new Admin("admin2@gmail.com", "another_password");
        adminRepository.save(admin1);
        adminRepository.save(admin2);
    }

    @AfterEach
    void tearDown() {
        adminRepository.deleteAll();
    }

    @Test
    void shouldFindById() {
        Admin a = adminRepository.findById(1);
        assertThat(a).isNotNull();
    }

    @Test
    void shouldFindByEmail() {
        assertThat(adminRepository.findByEmail("admin1@gmail.com")).isNotNull();
    }

    @Test
    void shouldFindAll() {
        assertThat(adminRepository.findAll()).isNotEmpty();
    }

    @Test
    void shouldSave() {
        Admin toSave = new Admin("new@gmail.com", "new pass");
        adminRepository.save(toSave);
        assertThat(adminRepository.findByEmail(adminRepository.findByEmail("new@gmail.com").getEmail())).isNotNull();
    }
}