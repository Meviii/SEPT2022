package com.mdonline.AccountService.Patient;


import com.mdonline.AccountService.User.User;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="patient")
public class Patient extends User {

    private Double weight;

    private String healthStatus;

    private String healthInformation;

    private boolean disabledStatus = false;

    public Patient() {
    }


    public Patient(String email, String password, String firstName, String middleName, String lastName, Date birth, Double weight, String healthStatus, String healthInformation) {
        super(email, password, firstName, middleName, lastName, birth);
        this.weight = weight;
        this.healthStatus = healthStatus;
        this.healthInformation = healthInformation;
    }

    public Double getPatientWeight() {
        return weight;
    }

    public void setPatientWeight(Double Weight) {
        this.weight = Weight;
    }

    public String getPatientHealthStatus() {
        return healthStatus;
    }

    public void setPatientHealthStatus(String HealthStatus) {
        this.healthStatus = HealthStatus;
    }

    public String getPatientHealthInformation() {
        return healthInformation;
    }

    public void setPatientHealthInformation(String HealthInformation) {
        this.healthInformation = HealthInformation;
    }

    public boolean isPatientDisabledStatus() {
        return disabledStatus;
    }

    public void setPatientDisabledStatus(boolean DisabledStatus) {
        this.disabledStatus = DisabledStatus;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Weight=" + weight +
                ", HealthStatus='" + healthStatus + '\'' +
                ", HealthInformation='" + healthInformation + '\'' +
                ", DisabledStatus=" + disabledStatus +
                '}';
    }


}
