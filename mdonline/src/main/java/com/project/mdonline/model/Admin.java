package com.project.mdonline.model;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin {

    @Id
    private int adminID;

    private String adminEmail;

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
                ", adminEmail='" + adminEmail + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}


