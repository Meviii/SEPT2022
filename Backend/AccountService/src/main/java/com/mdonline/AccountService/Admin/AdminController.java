package com.mdonline.AccountService.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
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

    // Returns admin by email
    @RequestMapping(path = "/{email}", consumes = "application/json", produces="application/json")
    @ResponseBody
    public Admin getAdminByEmail(@PathVariable String email) {
        return adminService.getAdminByEmail(email);
    }
}
