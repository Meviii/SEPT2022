package com.mdonline.AccountService.Repository;

import org.springframework.stereotype.Repository;

/**
 * @ExtendsTo UserRepository
 * This interface handles the Patient related database queries via JPA and Hibernate
 */
@Repository
public interface PatientRepository extends UserRepository {

}