package com.mdonline.AccountService.Repository;

import com.mdonline.AccountService.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface handles the Admin related database queries via JPA and Hibernate
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findById(long id);
    Admin findByEmail(String email);
    List<Admin> findAll();

    @Override
    <S extends Admin> S save(S entity);
}
