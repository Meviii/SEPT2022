package com.project.mdonline.model;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Qualifier("patients")
@Table(name="patient")
public class Patient {
    @Id
    @Column (name="patient_id", unique = true)
    private int patientID;

    private String patientEmail;

    private String patientPassword;

    private String patientFirstName;

    private String patientMiddleName;

    private String patientLastName;

    private int patientPhone;

    private Date patientBirth;

    private int patientStreetNo;

    private String patientStreetName;

    private String patientCity;

    private String patientSate;

    private int patientPostCode;

    private String patientCountry;

    private boolean patientVerifiedStatus;

    private int patientWeight;

    private String patientHealthStatus;

    private String patientHealthInformation;

    public Patient() {
    }

    public Patient(int patientID, String patientEmail, String patientPassword) {
        this.patientID = patientID;
        this.patientEmail = patientEmail;
        this.patientPassword = patientPassword;
    }

    public Patient(int patientID, String patientEmail, String patientPassword, int patientPhone) {
        this.patientID = patientID;
        this.patientEmail = patientEmail;
        this.patientPassword = patientPassword;
        this.patientPhone = patientPhone;
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

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientMiddleName() {
        return patientMiddleName;
    }

    public void setPatientMiddleName(String patientMiddleName) {
        this.patientMiddleName = patientMiddleName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public int getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(int patientPhone) {
        this.patientPhone = patientPhone;
    }

    public Date getPatientBirth() {
        return patientBirth;
    }

    public void setPatientBirth(Date patientBirth) {
        this.patientBirth = patientBirth;
    }

    public int getPatientStreetNo() {
        return patientStreetNo;
    }

    public void setPatientStreetNo(int patientStreetNo) {
        this.patientStreetNo = patientStreetNo;
    }

    public String getPatientStreetName() {
        return patientStreetName;
    }

    public void setPatientStreetName(String patientStreetName) {
        this.patientStreetName = patientStreetName;
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }

    public String getPatientSate() {
        return patientSate;
    }

    public void setPatientSate(String patientSate) {
        this.patientSate = patientSate;
    }

    public int getPatientPostCode() {
        return patientPostCode;
    }

    public void setPatientPostCode(int patientPostCode) {
        this.patientPostCode = patientPostCode;
    }

    public String getPatientCountry() {
        return patientCountry;
    }

    public void setPatientCountry(String patientCountry) {
        this.patientCountry = patientCountry;
    }

    public boolean isPatientVerifiedStatus() {
        return patientVerifiedStatus;
    }

    public void setPatientVerifiedStatus(boolean patientVerifiedStatus) {
        this.patientVerifiedStatus = patientVerifiedStatus;
    }

    public int getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(int patientWeight) {
        this.patientWeight = patientWeight;
    }

    public String getPatientHealthStatus() {
        return patientHealthStatus;
    }

    public void setPatientHealthStatus(String patientHealthStatus) {
        this.patientHealthStatus = patientHealthStatus;
    }

    public String getPatientHealthInformation() {
        return patientHealthInformation;
    }

    public void setPatientHealthInformation(String patientHealthInformation) {
        this.patientHealthInformation = patientHealthInformation;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getPatientFullName() {
        return "Patient{" +
                "patientFirstName='" + patientFirstName + '\'' +
                ", patientMiddleName='" + patientMiddleName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                '}';
    }

    public String getPatientFullAddress() {
        return "Patient{" +
                "patientStreetNo=" + patientStreetNo +
                ", patientStreetName='" + patientStreetName + '\'' +
                ", patientCity='" + patientCity + '\'' +
                ", patientSate='" + patientSate + '\'' +
                ", patientPostCode=" + patientPostCode +
                ", patientCountry='" + patientCountry + '\'' +
                '}';
    }

    public String getPatientFullHealthStatus(){
        return "Patient{" +
                "patientWeight=" + patientWeight +
                ", patientHealthStatus='" + patientHealthStatus + '\'' +
                ", patientHealthInformation='" + patientHealthInformation + '\'' +
                '}';

    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", patientEmail='" + patientEmail + '\'' +
                ", patientPassword='" + patientPassword + '\'' +
                ", patientFirstName='" + patientFirstName + '\'' +
                ", patientMiddleName='" + patientMiddleName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", patientPhone=" + patientPhone +
                ", patientBirth=" + patientBirth +
                ", patientStreetNo=" + patientStreetNo +
                ", patientStreetName='" + patientStreetName + '\'' +
                ", patientCity='" + patientCity + '\'' +
                ", patientSate='" + patientSate + '\'' +
                ", patientPostCode=" + patientPostCode +
                ", patientCountry='" + patientCountry + '\'' +
                ", patientVerifiedStatus=" + patientVerifiedStatus +
                ", patientWeight=" + patientWeight +
                ", patientHealthStatus='" + patientHealthStatus + '\'' +
                ", patientHealthInformation='" + patientHealthInformation + '\'' +
                '}';
    }
}
