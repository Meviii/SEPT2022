package com.mdonline.LoginService.Model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Child Child of the User class
 *
 * This class holds the data of the doctor object.
 */
@Entity
@Table(name="doctors")
@DiscriminatorValue(value = "Doctor")
public class Doctor extends User {

    private String profession;

    public Doctor() {
    }

}
