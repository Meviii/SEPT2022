package com.mdonline.AccountService.Model.User;

import com.mdonline.AccountService.Model.Address;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Date;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    @Email
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "user_type", insertable = false, updatable = false)
    private String userType;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "phone", unique = true)
    private Long phone;

    @Column(nullable = false, name = "birth")
    private Date birth;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private GenderOption gender;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="address_id", referencedColumnName = "id")
    private Address address;

    @Column(name="verified_status")
    private boolean verifiedStatus;

    @Column(name="disabled_status")
    private boolean disabledStatus;

    public User() {
    }

    public User(String email, String password, String firstName, String middleName, String lastName, Date birth, Long phone, GenderOption gender) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birth = birth;
        this.phone = phone;
        this.gender = gender;
    }

    public String getUserType() {
        return userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getDisabledStatus() {
        return disabledStatus;
    }

    public void setDisabledStatus(boolean DisabledStatus) {
        this.disabledStatus = DisabledStatus;
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public boolean isVerifiedStatus() {
        return verifiedStatus;
    }

    public void setVerifiedStatus(boolean verifiedStatus) {
        this.verifiedStatus = verifiedStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public GenderOption getGender() {
        return gender;
    }

    public void setGender(GenderOption gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
