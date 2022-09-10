package com.mdonline.AccountService.Model.User;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="patients")
@DiscriminatorValue(value = "Patient")
public class Patient extends User {

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "health_information")
    private String healthInformation;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "health_status")
    private HealthStatus healthStatus;

    public Patient() {
    }

    public Patient(String email, String password, String firstName, String middleName, String lastName, Date birth, Long phone, GenderOption gender) {
        super(email, password, firstName, middleName, lastName, birth, phone, gender);
    }

    public Patient(String email, String password, String firstName, String middleName, String lastName, Date birth, Long phone, GenderOption gender, Double height, Double weight, String healthInformation, HealthStatus healthStatus) {
        super(email, password, firstName, middleName, lastName, birth, phone, gender);
        this.height = height;
        this.weight = weight;
        this.healthInformation = healthInformation;
        this.healthStatus = healthStatus;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double Weight) {
        this.weight = Weight;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus HealthStatus) {
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
                "height=" + height +
                ", weight=" + weight +
                ", healthInformation='" + healthInformation + '\'' +
                ", healthStatus=" + healthStatus +
                '}';
    }
}
