package com.mdonline.LoginService.Doctor;


import com.mdonline.LoginService.User.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="doctors")
@DiscriminatorValue(value = "Doctor")
public class Doctor extends User {

    private String profession;

    public Doctor() {
    }

}
