package com.system.ZenDesk.Widget.service;


import com.system.ZenDesk.Widget.model.User;
import com.system.ZenDesk.Widget.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService  implements UserDetailsService {

     @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user =userRepo.findByEmail(email);
        GrantedAuthority grantedAuthority= new SimpleGrantedAuthority("PRE_AUTH");
        UserDetails userDetails= (UserDetails) new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), Arrays.asList(grantedAuthority));
        return userDetails;
    }



}
