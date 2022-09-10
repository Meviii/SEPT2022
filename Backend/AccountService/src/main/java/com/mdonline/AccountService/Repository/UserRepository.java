package com.mdonline.AccountService.Repository;

import com.mdonline.AccountService.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findByEmail(String email);

    void deleteById(long integer);

    @Override
    <S extends User> S save(S entity);
}
