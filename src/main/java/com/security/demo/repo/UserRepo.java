package com.security.demo.repo;

import com.security.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {

    //Spring Data JPA Query Method Naming Convention
    //SELECT * FROM users WHERE username = ?;
     Users findByUserName(String userName);
}
