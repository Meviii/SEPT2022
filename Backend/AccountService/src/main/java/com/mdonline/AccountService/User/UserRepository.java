package com.mdonline.AccountService.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface UserRepository extends JpaRepository<User, Integer> {

}
