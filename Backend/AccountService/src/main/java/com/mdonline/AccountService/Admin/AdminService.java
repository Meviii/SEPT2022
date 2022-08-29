package com.mdonline.AccountService.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
        System.out.println("Admin service layer created.");
    }

    public Admin getAdminById(int id){
        return adminRepository.findByAdminID(id);
    }

    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }

    public Admin getAdminByEmail(String email){
        return adminRepository.findByAdminEmail(email);
    }

    public void updateAdmin(Admin toUpdate) {
        adminRepository.save(toUpdate);
    }

    public void createAdmin(Admin toCreate) {
        adminRepository.save(toCreate);
    }

    public void deleteUser(int id) {
        adminRepository.delete(adminRepository.findByAdminID(id));
    }
}
