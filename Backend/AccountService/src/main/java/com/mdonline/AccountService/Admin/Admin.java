package com.mdonline.AccountService.Admin;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="admin_id")
    private int adminID;

    @Column(name = "admin_email", unique = true, nullable = false)
    private String adminEmail;

    @Column(name = "admin_password",nullable = false)
    private String adminPassword;

    public Admin(){}

    public Admin(String adminEmail, String adminPassword){
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    public int getAdminID() {
        return adminID;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", adminEmail='" + adminEmail +
                '}';
    }
}


