package com.mdonline.AccountService.Admin;

import com.mdonline.AccountService.Doctor.Doctor;
import com.mdonline.AccountService.Patient.Patient;
import com.mdonline.AccountService.User.User;
import com.mdonline.AccountService.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/admin")
public class AdminController {

    AdminService adminService;
    Utility utility;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
        this.utility = new Utility();
    }

    @GetMapping(path="/{id}", consumes = "application/json", produces="application/json")
    @ResponseBody
    public Admin getAdminById(@PathVariable int id) {
        try {
            return adminService.getAdminById(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found", e);
        }
    }

    @GetMapping(consumes = "application/json", produces="application/json")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmin();
    }

    @RequestMapping(path = "/{email}", consumes = "application/json", produces="application/json")
    @ResponseBody
    public Admin getAdminByEmail(@PathVariable String email) {
        return adminService.getAdminByEmail(email);
    }


    @PutMapping(path="/{id}", consumes = "application/json", produces="application/json")
    public ResponseEntity<String> updateAdmin(@RequestBody String jsonString, @PathVariable int id) {

        try {
            Admin toUpdate = utility.jsonStringToAdmin(jsonString);
            adminService.updateAdmin(toUpdate);
        } catch (MethodNotAllowedException e) {
            return new ResponseEntity<>("Incorrect Method", HttpStatus.METHOD_NOT_ALLOWED);
        } catch (Exception e) {
            return new ResponseEntity<>("User does not exist or incorrect format", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User updated.", HttpStatus.OK);
    }

    // Update specified patient
    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity<String> createAdmin(@RequestBody String jsonString) {
        try {
            Admin toUpdate = utility.jsonStringToAdmin(jsonString);
            adminService.createAdmin(toUpdate);
        }catch (MethodNotAllowedException e){
            return new ResponseEntity<>("Incorrect Method", HttpStatus.METHOD_NOT_ALLOWED);
        }catch (Exception e){
            return new ResponseEntity<>("Incorrect Format", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User added.", HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable int id){
        try {
            adminService.deleteUser(id);
        }catch (MethodNotAllowedException e){
            return new ResponseEntity<>("Incorrect Method", HttpStatus.METHOD_NOT_ALLOWED);
        }catch (Exception e){
            return new ResponseEntity<>("User does not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("User deleted.", HttpStatus.OK);
    }
}
