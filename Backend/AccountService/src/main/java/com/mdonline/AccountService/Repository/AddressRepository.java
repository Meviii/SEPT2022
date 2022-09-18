package com.mdonline.AccountService.Repository;

import com.mdonline.AccountService.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface handles the Address related database queries via JPA and Hibernate
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findById(long id);
}
