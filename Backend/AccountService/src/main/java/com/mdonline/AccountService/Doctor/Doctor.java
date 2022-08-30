package com.mdonline.AccountService.Doctor;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mdonline.AccountService.Patient.Patient;
import com.mdonline.AccountService.User.GenderOption;
import com.mdonline.AccountService.User.User;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="doctors")
@DiscriminatorValue(value = "Doctor")
public class Doctor extends User {

    private String profession;

    public Doctor() {
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Doctor(String email, String password, String firstName, String middleName, String lastName, Date birth, Long phone, GenderOption gender, String profession) {
        super(email, password, firstName, middleName, lastName, birth, phone, gender);
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "profession='" + profession + '\'' +
                '}';
    }

    @JsonIgnore
    public void update(Doctor doctor){
        this.update(doctor);
        this.profession = doctor.profession;
    }
}
