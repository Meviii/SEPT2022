package com.mdonline.AccountService.Patient;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mdonline.AccountService.User.User;

import javax.persistence.*;
import java.sql.Date;


@Entity
@DiscriminatorValue(value = "Patient")
public class Patient extends User {

    private Double weight;

    private String healthStatus;

    private String healthInformation;

    public Patient() {
    }

    public Patient(String email, String password, String firstName, String middleName, String lastName, Date birth, Integer phone, Double weight, String healthStatus, String healthInformation) {
        super(email, password, firstName, middleName, lastName, birth, phone);
        this.weight = weight;
        this.healthStatus = healthStatus;
        this.healthInformation = healthInformation;
    }


    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double Weight) {
        this.weight = Weight;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String HealthStatus) {
        this.healthStatus = HealthStatus;
    }

    public String getHealthInformation() {
        return healthInformation;
    }

    public void setHealthInformation(String HealthInformation) {
        this.healthInformation = HealthInformation;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Weight=" + weight +
                ", HealthStatus='" + healthStatus + '\'' +
                ", HealthInformation='" + healthInformation + '\'' +
                '}';
    }

    @JsonIgnore
    public void update(Patient patient){
        this.update(patient);
        this.weight = patient.weight;
        this.healthStatus = patient.healthStatus;
        this.healthInformation = patient.healthInformation;
    }

}
