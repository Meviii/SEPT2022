package com.project.mdonline.service;

import com.project.mdonline.model.Admin;
import com.project.mdonline.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public AdminService(){
        System.out.println("Service layer created.");
    }

    public Admin getAdminById(int id){


        return adminRepository.findAdminByAdminID(id);
    }

    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }

    public Admin getAdminByEmail(String email){
        return adminRepository.findAdminByAdminEmail(email);
    }
}
