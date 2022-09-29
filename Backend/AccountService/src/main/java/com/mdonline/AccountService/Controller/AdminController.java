package com.mdonline.AccountService.Controller;

import com.mdonline.AccountService.Exceptions.CustomException;
import com.mdonline.AccountService.Model.Admin;
import com.mdonline.AccountService.Service.AdminService;
import com.mdonline.AccountService.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * WEB Endpoint controller/ URI Controller
 */
@RestController
@RequestMapping(path="/api/v1/admins")
public class AdminController {

    private AdminService adminService;
    private Utility utility;

    /**
     * Main constructor for the admin controller with admin service
     * @param adminService
     */
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
        this.utility = new Utility();
    }

    /**
     * Returns the admin details by the unique admin id
     * @param id - admin id
     */
    @GetMapping(path="/{id}", produces="application/json")
    @ResponseBody
    public Admin getAdminById(@PathVariable long id) {
        Admin admin = adminService.getAdminById(id);

        if (admin == null){
            throw new CustomException("Admin doesn't exist.", HttpStatus.NOT_FOUND);
        }

        return admin;
    }

    /**
     * Returns the details of all admins
     */
    @GetMapping(produces="application/json")
    public List<Admin> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmin();

        if (admins.isEmpty()){
            throw new CustomException("No admins currently.", HttpStatus.OK);
        }

        return admins;
    }

    /**
     * Returns the admin details by the unique admin email
     * @param email - admin email
     */
    @RequestMapping(path = "email/{email}", produces="application/json")
    @ResponseBody
    public Admin getAdminByEmail(@PathVariable String email) {
        Admin admin = adminService.getAdminByEmail(email);

        if (admin == null){
            throw new CustomException("Admin doesn't exist.", HttpStatus.NOT_FOUND);
        }

        return adminService.getAdminByEmail(email);
    }

    /**
     * Updates the admin by the given payload and id
     *
     * @param id - user id
     * @param admin - Entity object of admin
     */
    @PutMapping(path="/{id}", consumes = "application/json", produces="application/json")
    public ResponseEntity<String> updateAdmin(@RequestBody Admin admin, @PathVariable long id) {

        Boolean isUpdated = adminService.updateAdmin(admin, id);

        if (isUpdated == false){
            throw new CustomException("Couldn't update", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Admin updated.", HttpStatus.OK);
    }

    /**
     * Creates a user by a given valid payload
     *
     * @param admin - Entity object of admin
     */
    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity<?> createAdmin(@RequestBody Admin admin) {

        Boolean isCreated = adminService.createAdmin(admin);
        if (isCreated == false){
            throw new CustomException("Couldn't create. Might already exist", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Admin added.", HttpStatus.CREATED);
    }

    /**
     * Deletes an admin by a given valid id
     *
     * @param id - id of admin
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable long id){

        Boolean isDeleted = adminService.deleteAdmin(id);

        if (isDeleted == false){
            throw new CustomException("Couldn't delete.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Admin deleted.", HttpStatus.OK);
    }

    /**
     * Deletes all users
     *
     */
    @DeleteMapping(path = "/")
    public ResponseEntity<?> deleteAll(){

        Boolean isDeleted = adminService.deleteAll();

        if (isDeleted == false){
            throw new CustomException("Couldn't delete all.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("All admins deleted.", HttpStatus.OK);
    }
}
