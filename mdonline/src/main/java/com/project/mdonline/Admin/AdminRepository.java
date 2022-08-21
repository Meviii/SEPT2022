package com.project.mdonline.Admin;

import com.project.mdonline.Admin.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

    Admin findAdminByAdminID(int id);
    Admin findAdminByAdminEmail(String email);
    // Returns admin by id in database
    List<Admin> findAll();
}
