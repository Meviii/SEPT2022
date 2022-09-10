package com.mdonline.AccountService.Service;

import com.mdonline.AccountService.Model.Admin;
import com.mdonline.AccountService.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    AdminRepository adminRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        System.out.println("Admin service layer created.");
    }

    public Admin getAdminById(long id){
        return adminRepository.findById(id);
    }

    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }

    public Admin getAdminByEmail(String email){
        return adminRepository.findByEmail(email);
    }

    public void updateAdmin(Admin toUpdate, long id) {
        toUpdate.setId(id);
        toUpdate.setPassword(passwordEncoder.encode(toUpdate.getPassword()));
        adminRepository.save(toUpdate);
    }

    public void createAdmin(Admin toCreate) {
        toCreate.setPassword(passwordEncoder.encode(toCreate.getPassword()));
        adminRepository.save(toCreate);
    }

    public void deleteAdmin(long id) {
        adminRepository.delete(adminRepository.findById(id));
    }

    public void deleteAll() {
        adminRepository.deleteAll();
    }
}
