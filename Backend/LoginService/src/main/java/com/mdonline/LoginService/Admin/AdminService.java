package com.mdonline.LoginService.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public AdminService(){
        System.out.println("Admin service layer created.");
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
