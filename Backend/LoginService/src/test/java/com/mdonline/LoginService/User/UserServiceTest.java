package com.mdonline.LoginService.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

//    @InjectMocks
//    private UserService userService;

    @BeforeEach
    void setUp() {
//        this.userService = new UserService(userRepository);
//        String date = "2000-02-20";
//        Date dt = Date.valueOf(date);
//        User patientToTest = new Patient("email1@gmail.com", "pass",
//                "first", "last", "lasts", dt, 12312L, GenderOption.MALE);
//
//        User doctorToTest = new Doctor("email2@gmail.com", "pass",
//                "first", "last", "lasts"
//                , dt, 12321312L, GenderOption.MALE, "some profession");
//
//        userRepository.save(patientToTest); // id of 1
//        userRepository.save(doctorToTest); // id of 2
    }

//    @AfterEach
//    void tearDown(){
//        userRepository.deleteAll();
//    }
//
//    @Test
//    void authUser() {
//        userService.getAllUsers();
//        verify(userRepository).findAll();
//    }

}