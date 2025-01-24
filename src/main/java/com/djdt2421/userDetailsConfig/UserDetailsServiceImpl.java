package com.djdt2421.userDetailsConfig;

import com.djdt2421.entities.User;
import com.djdt2421.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = null;
        try {
           user = userRepository.findByUserName(username);
       }catch (Exception e){
           System.out.print("User Not Found");
       }

        return new UserDetailsImpl(user);
    }



}
