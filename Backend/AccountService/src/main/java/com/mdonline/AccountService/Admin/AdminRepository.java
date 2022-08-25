package com.mdonline.AccountService.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findAdminByAdminID(int id);
    Admin findAdminByAdminEmail(String email);
    // Returns admin by id in database
    List<Admin> findAll();

    @Override
    <S extends Admin> S save(S entity);
}
