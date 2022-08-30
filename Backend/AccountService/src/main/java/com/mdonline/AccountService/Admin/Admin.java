package com.mdonline.AccountService.Admin;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    public Admin(){}

    public Admin(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Long getAdminID() {
        return id;
    }

    public String getAdminEmail() {
        return email;
    }

    public void setAdminEmail(String email) {
        this.email = email;
    }

    public String getAdminPassword() {
        return password;
    }

    public void setAdminPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + id +
                ", adminEmail='" + email +
                '}';
    }
}


