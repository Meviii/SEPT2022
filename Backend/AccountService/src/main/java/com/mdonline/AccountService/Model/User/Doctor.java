package com.mdonline.AccountService.Model.User;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

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

}
