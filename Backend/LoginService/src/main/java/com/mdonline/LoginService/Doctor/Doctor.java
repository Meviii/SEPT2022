package com.mdonline.LoginService.Doctor;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="doctor")
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorID;

    @Column(name = "doctor_email", unique = true, nullable = false)
    private String doctorEmail;

    @Column(name = "doctor_password", nullable = false)
    private String doctorPassword;

    @Column(name = "doctor_disabled_status", nullable = false)
    private boolean doctorDisabledStatus;

    @JsonIgnore
    private boolean doctorCanLogin = false;

    public Doctor() {}

    public Doctor(String doctorEmail, String doctorPassword) {
        this.doctorEmail = doctorEmail;
        this.doctorPassword = doctorPassword;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public boolean isDoctorDisabledStatus() {
        return doctorDisabledStatus;
    }

    public boolean isDoctorCanLogin() {
        return doctorCanLogin;
    }

    public void setDoctorCanLogin(boolean doctorCanLogin) {
        this.doctorCanLogin = doctorCanLogin;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", doctorEmail='" + doctorEmail + '\'' +
                '}';
    }

    public boolean isEnabled() {
        return doctorDisabledStatus;
    }

    @JsonIgnore
    public boolean canLogin(){
        return doctorCanLogin;
    }
}
