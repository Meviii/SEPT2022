package com.mdonline.AccountService.User;

import com.mdonline.AccountService.Patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findByEmail(String email);

    void deleteById(long integer);

    @Override
    <S extends User> S save(S entity);
}
