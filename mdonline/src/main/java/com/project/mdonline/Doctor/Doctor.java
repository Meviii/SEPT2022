package com.project.mdonline.Doctor;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="doctor")
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorID;

    private String doctorEmail;

    private String doctorPassword;

    private String doctorFirstName;

    private String doctorMiddleName;

    private String doctorLastName;

    private int doctorPhone;

    private Date doctorBirth;

    private int doctorStreetNo;

    private String doctorStreetName;

    private String doctorCity;

    private String doctorState;

    private int doctorPostCode;

    private String doctorCountry;

    private boolean doctorVerifiedStatus;


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


    public int getDoctorID() {
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
}
