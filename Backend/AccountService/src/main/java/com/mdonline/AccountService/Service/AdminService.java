package com.mdonline.AccountService.Service;

import com.mdonline.AccountService.Model.Admin;
import com.mdonline.AccountService.Repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Business logic of Admin URI endpoints and data handling.
 */
@Service
public class AdminService {

    AdminRepository adminRepository;
    PasswordEncoder passwordEncoder;
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);

    /**
     * Main constructor for the Admin service.
     *
     * @param adminRepository - Initializes global admin repository
     * @param passwordEncoder - Initializes global Bcrypt password encoder
     */
    @Autowired
    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        LOGGER.info("Admin service started.");
    }

    /**
     * Finds and returns an Admin by email if it is found in the datastore.
     *
     * @param id - Admin id
     * @Return - Admin OR null
     */
    public Admin getAdminById(long id){
        LOGGER.info("Getting admin with ID: " + id);
        return adminRepository.findById(id);
    }

    /**
     * Finds and returns a List of all admins found in the datastore.
     *
     * @Return - List<Admin>
     */
    public List<Admin> getAllAdmin(){
        LOGGER.info("Getting all admins");
        return adminRepository.findAll();
    }

    /**
     * Finds and returns an Admin by email if it is found in the datastore.
     *
     * @param email - Admin email
     *
     * @Return - Admin OR null
     */
    public Admin getAdminByEmail(String email){
        LOGGER.info("Getting Admin with Email: " + email);
        return adminRepository.findByEmail(email);
    }

    /**
     * Finds and updates an Admin by given Admin object and id if id is found in the datastore.
     *
     * @param toUpdate - Admin object
     * @param id - Admin id
     *
     * @Return - Boolean value representing if admin has been updated
     */
    public Boolean updateAdmin(Admin toUpdate, long id) {
        boolean isUpdated = true;
        LOGGER.info("Updating admin with ID: " + id);
        try {
            toUpdate.setId(id);
            toUpdate.setPassword(passwordEncoder.encode(toUpdate.getPassword()));
            adminRepository.save(toUpdate);
        }catch (Exception e){
            isUpdated = false;
        }

        return isUpdated;
    }

    /**
     * Creates a new Admin and saves into datastore.
     *
     * @param toCreate - Admin object to save
     *
     * @Return - Boolean value representing if admin has been created
     */
    public Boolean createAdmin(Admin toCreate) {
        LOGGER.info("Creating admin.");
        boolean isCreated = true;
        try {
            toCreate.setPassword(passwordEncoder.encode(toCreate.getPassword()));
            adminRepository.save(toCreate);
        }catch (Exception e){
            isCreated = false;
        }

        return isCreated;
    }

    /**
     * Deletes an Admin if id exists in datastore
     *
     * @param id - Admin id to delete
     *
     * @Return - Boolean value representing if admin has been deleted
     */
    public Boolean deleteAdmin(long id) {
        LOGGER.info("Deleting admin with ID: " + id);
        boolean isDeleted = true;
        try {
            adminRepository.delete(adminRepository.findById(id));
        }catch (Exception e){
            isDeleted = false;
        }
        return isDeleted;
    }

    /**
     * Deletes all Admins that exist in the datastore
     *
     * @Return - Boolean value representing if admins have been deleted
     */
    public Boolean deleteAll() {
        LOGGER.info("Deleting all admins.");
        boolean isDeleted = true;
        try {
            adminRepository.deleteAll();
        }catch (Exception e){
            isDeleted = false;
        }
        return isDeleted;
    }
}
