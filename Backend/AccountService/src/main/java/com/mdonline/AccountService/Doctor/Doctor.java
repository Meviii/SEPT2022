package com.mdonline.AccountService.Doctor;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="doctor")
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer doctorID;

    @Column(unique = true, nullable = false)
    private String doctorEmail;

    @Column(nullable = false)
    private String doctorPassword;

    @Column(nullable = false)
    private String doctorFirstName;

    private String doctorMiddleName;

    @Column(nullable = false)
    private String doctorLastName;

    @Column(nullable = false)
    private int doctorPhone;

    private Date doctorBirth;

    private int doctorStreetNo;

    private String doctorStreetName;

    private String doctorCity;

    private String doctorState;

    private int doctorPostCode;

    private String doctorCountry;

    private boolean doctorVerifiedStatus;

    private boolean doctorDisabledStatus = false;

    public Doctor() {
    }

    public Doctor(String doctorEmail, String doctorPassword) {
        this.doctorEmail = doctorEmail;
        this.doctorPassword = doctorPassword;
    }

    public Doctor(String doctorEmail, String doctorPassword, int doctorPhone) {
        this.doctorEmail = doctorEmail;
        this.doctorPassword = doctorPassword;
        this.doctorPhone = doctorPhone;
    }

    public Doctor(String doctorEmail, String doctorPassword, String doctorFirstName, String doctorMiddleName, String doctorLastName, int doctorPhone, Date doctorBirth) {
        this.doctorEmail = doctorEmail;
        this.doctorPassword = doctorPassword;
        this.doctorFirstName = doctorFirstName;
        this.doctorMiddleName = doctorMiddleName;
        this.doctorLastName = doctorLastName;
        this.doctorPhone = doctorPhone;
        this.doctorBirth = doctorBirth;
    }

    public boolean isPatientDisabledStatus() {
        return doctorDisabledStatus;
    }

    public void setPatientDisabledStatus(boolean patientDisabledStatus) {
        this.doctorDisabledStatus = patientDisabledStatus;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
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

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorMiddleName() {
        return doctorMiddleName;
    }

    public void setDoctorMiddleName(String doctorMiddleName) {
        this.doctorMiddleName = doctorMiddleName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public int getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(int doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public Date getDoctorBirth() {
        return doctorBirth;
    }

    public void setDoctorBirth(Date doctorBirth) {
        this.doctorBirth = doctorBirth;
    }

    public int getDoctorStreetNo() {
        return doctorStreetNo;
    }

    public void setDoctorStreetNo(int doctorStreetNo) {
        this.doctorStreetNo = doctorStreetNo;
    }

    public String getDoctorStreetName() {
        return doctorStreetName;
    }

    public void setDoctorStreetName(String doctorStreetName) {
        this.doctorStreetName = doctorStreetName;
    }

    public String getDoctorCity() {
        return doctorCity;
    }

    public void setDoctorCity(String doctorCity) {
        this.doctorCity = doctorCity;
    }

    public String getDoctorState() {
        return doctorState;
    }

    public void setDoctorState(String doctorSate) {
        this.doctorState = doctorSate;
    }

    public int getDoctorPostCode() {
        return doctorPostCode;
    }

    public void setDoctorPostCode(int doctorPostCode) {
        this.doctorPostCode = doctorPostCode;
    }

    public String getDoctorCountry() {
        return doctorCountry;
    }

    public void setDoctorCountry(String doctorCountry) {
        this.doctorCountry = doctorCountry;
    }

    public boolean isDoctorVerifiedStatus() {
        return doctorVerifiedStatus;
    }

    public void setDoctorVerifiedStatus(boolean doctorVerifiedStatus) {
        this.doctorVerifiedStatus = doctorVerifiedStatus;
    }


    public Integer getDoctorID() {
        return doctorID;
    }

    public String getDoctorFullName() {
        return "Doctor{" +
                "doctorFirstName='" + doctorFirstName + '\'' +
                ", doctorMiddleName='" + doctorMiddleName + '\'' +
                ", doctorLastName='" + doctorLastName + '\'' +
                '}';
    }

    public String getDoctorFullAddress() {
        return "Doctor{" +
                "doctorStreetNo=" + doctorStreetNo +
                ", doctorStreetName='" + doctorStreetName + '\'' +
                ", doctorCity='" + doctorCity + '\'' +
                ", doctorSate='" + doctorState + '\'' +
                ", doctorPostCode=" + doctorPostCode +
                ", doctorCountry='" + doctorCountry + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", doctorPassword='" + doctorPassword + '\'' +
                ", doctorFirstName='" + doctorFirstName + '\'' +
                ", doctorMiddleName='" + doctorMiddleName + '\'' +
                ", doctorLastName='" + doctorLastName + '\'' +
                ", doctorPhone=" + doctorPhone +
                ", doctorBirth=" + doctorBirth +
                ", doctorStreetNo=" + doctorStreetNo +
                ", doctorStreetName='" + doctorStreetName + '\'' +
                ", doctorCity='" + doctorCity + '\'' +
                ", doctorSate='" + doctorState + '\'' +
                ", doctorPostCode=" + doctorPostCode +
                ", doctorCountry='" + doctorCountry + '\'' +
                ", doctorVerifiedStatus=" + doctorVerifiedStatus +
                '}';
    }

    public boolean isEnabled() {
        return doctorDisabledStatus;
    }

}
