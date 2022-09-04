package com.mdonline.LoginService.User;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

//    @Autowired
//    UserRepository userRepository;
//
//    @BeforeEach
//    void setUp() {
//        this.userRepository = userRepository;
//
//        String date = "2000-02-20";
//        Date dt = Date.valueOf(date);
//        User patientOne = new Patient("email1@gmail.com", "pass",
//                "first", "last", "lasts", dt, 12312L, GenderOption.MALE);
//
//
//        userRepository.save(patientOne);
//    }
//
//    @AfterEach
//    void tearDown() {
//        userRepository.deleteAll();
//    }

//    @Test
//    void findById() {
//
//        assertThat(userRepository.findById(1)).isNotNull();
//    }
//
//    @Test
//    void findByEmail() {
//        assertThat(userRepository.findByEmail("email1@gmail.com")).isNotNull();
//    }
//
//    @Test
//    void deleteById() {
//        userRepository.deleteById(1);
//        assertThat(userRepository.findById(1)).isNull();
//    }
}