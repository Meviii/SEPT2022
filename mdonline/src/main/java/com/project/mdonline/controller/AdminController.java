package com.project.mdonline.controller;

import com.project.mdonline.model.Admin;
import com.project.mdonline.repository.AdminRepository;
import com.project.mdonline.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping
    public String checkWorking(){
        return "App is working...";
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Admin getAdmin(@PathVariable int id) {
        return adminService.getAdminById(id);
    }

    @GetMapping(path="/all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmin();
    }
}
