package com.mdonline.LoginService.Auth;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class AuthRequest {

    @Email
    private String email;

    @Length(min=2, max=255)
    private String password;

    private String userType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
