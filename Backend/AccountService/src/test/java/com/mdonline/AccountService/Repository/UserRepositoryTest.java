package com.mdonline.AccountService.Repository;

import com.mdonline.AccountService.Model.User.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        Date date = new Date(-1);
        User patient = new Patient("email1@gmail.com", "password", "Name", "Middle", "Last",
                date, 042312L, GenderOption.MALE, 120.0, 120.0, "Healthy", HealthStatus.GOOD);

        User doctor = new Doctor("email2@gmail.com", "password", "Name", "Middle", "Last",
                date, 04232212L, GenderOption.MALE, "profession");

        userRepository.save(patient);
        userRepository.save(doctor);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void shouldFindById() {
        User u = userRepository.findById(1);
        assertThat(u).isNotNull();
    }

    @Test
    void shouldFindByEmail() {
        assertThat(userRepository.findByEmail("email1@gmail.com")).isNotNull();
    }

    @Test
    void shouldFindAll() {
        assertThat(userRepository.findAll()).isNotEmpty();
    }

    @Test
    void shouldSave() {
        Date date = new Date(-1);
        User patient = new Patient("new@gmail.com", "password", "Name", "Middle", "Last",
                date, 042222312L, GenderOption.MALE, 120.0, 120.0, "Healthy", HealthStatus.GOOD);

        userRepository.save(patient);
        assertThat(userRepository.findByEmail(userRepository.findByEmail("new@gmail.com").getEmail())).isNotNull();
    }
}