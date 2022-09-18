package com.mdonline.LoginService.Repository;

import com.mdonline.LoginService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface handles the User(including Patient, Doctor) related database queries via JPA and Hibernate
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
