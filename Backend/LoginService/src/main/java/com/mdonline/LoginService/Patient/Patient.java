package com.mdonline.LoginService.Patient;

import com.mdonline.LoginService.User.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="patients")
@DiscriminatorValue(value = "Patient")
public class Patient extends User {

    public Patient() {
    }

}
