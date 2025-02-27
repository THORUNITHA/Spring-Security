package com.security.demo.service;

import com.security.demo.model.UserPrincipal;
import com.security.demo.model.Users;
import com.security.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
System.out.println(username);
Users user = repo.findByUserName(username);
if(user==null){
    System.out.println("User Not Found");
    throw new UsernameNotFoundException("User not exists");
}
        return new UserPrincipal(user);
    }
}
