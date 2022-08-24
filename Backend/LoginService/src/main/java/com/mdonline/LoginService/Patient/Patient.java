package com.mdonline.LoginService.Patient;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientID;

    @Column(unique = true, nullable = false)
    private String patientEmail;

    @Column(nullable = false)
    private String patientPassword;

    private boolean patientDisabledStatus;

    public Patient() { }

    public Patient(String patientEmail, String patientPassword) {
        this.patientEmail = patientEmail;
        this.patientPassword = patientPassword;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    public boolean getPatientDisabledStatus() {
        return patientDisabledStatus;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", patientEmail='" + patientEmail + '\'' +
                ", patientDisabledStatus=" + patientDisabledStatus +
                '}';
    }

    public boolean isEnabled() {
        return patientDisabledStatus;
    }
}