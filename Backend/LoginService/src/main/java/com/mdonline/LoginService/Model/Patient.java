package com.mdonline.LoginService.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Child Child of the User class
 *
 * This class holds the data of the patient object.
 */
@Entity
@Table(name="patients")
@DiscriminatorValue(value = "Patient")
public class Patient extends User {

    public Patient() {
    }

}
