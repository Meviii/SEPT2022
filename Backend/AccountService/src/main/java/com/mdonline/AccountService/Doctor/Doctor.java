package com.mdonline.AccountService.Doctor;


import com.mdonline.AccountService.User.User;

import javax.persistence.*;

@Entity
@Table(name="doctor")
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

    @Override
    public String toString() {
        return "Doctor{" +
                "profession='" + profession + '\'' +
                '}';
    }
}
