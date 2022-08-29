package com.mdonline.AccountService.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByAdminID(int id);
    Admin findByAdminEmail(String email);
    List<Admin> findAll();

    @Override
    <S extends Admin> S save(S entity);
}
