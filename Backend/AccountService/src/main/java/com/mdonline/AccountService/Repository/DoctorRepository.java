package com.mdonline.AccountService.Repository;

import org.springframework.stereotype.Repository;

/**
 * @ExtendsTo UserRepository
 * This interface handles the Doctor related database queries via JPA and Hibernate
 */
@Repository
public interface DoctorRepository extends UserRepository {

}