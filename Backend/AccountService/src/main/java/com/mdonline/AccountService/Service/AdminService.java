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

    public Boolean updateAdmin(Admin toUpdate, long id) {
        Boolean isUpdated = true;
        try {
            toUpdate.setId(id);
            toUpdate.setPassword(passwordEncoder.encode(toUpdate.getPassword()));
            adminRepository.save(toUpdate);
        }catch (Exception e){
            isUpdated = false;
        }

        return isUpdated;
    }

    public Boolean createAdmin(Admin toCreate) {
        Boolean isCreated = true;
        try {
            toCreate.setPassword(passwordEncoder.encode(toCreate.getPassword()));
            adminRepository.save(toCreate);
        }catch (Exception e){
            isCreated = false;
        }

        return isCreated;
    }

    public Boolean deleteAdmin(long id) {
        Boolean isDeleted = true;
        try {
            adminRepository.delete(adminRepository.findById(id));
        }catch (Exception e){
            isDeleted = false;
        }
        return isDeleted;
    }

    public Boolean deleteAll() {
        Boolean isDeleted = true;
        try {
            adminRepository.deleteAll();
        }catch (Exception e){
            isDeleted = false;
        }
        return isDeleted;
    }
}
