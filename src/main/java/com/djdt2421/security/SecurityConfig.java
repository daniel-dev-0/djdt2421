package com.djdt2421.security;

import com.djdt2421.userDetailsConfig.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
   UserDetailsServiceImpl us;

    public SecurityConfig(UserDetailsServiceImpl us) {
        this.us = us;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSec) throws Exception {
       httpSec.csrf(csrf -> csrf.disable())
               .authorizeHttpRequests(auth ->auth
                       .requestMatchers("/showAllStudents").hasRole("ADMIN")
                       .requestMatchers("/showAllCourses").permitAll()
               );
        return httpSec.build();
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(us);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
//        UserDetails userDetails = User.withUsername("Valera")
//                .password(passwordEncoder.encode("Valera1"))
//                .roles("USER")
//                .build();
//        UserDetails userDetails1 = User.withUsername("Admin")
//                .password(passwordEncoder.encode("AdminPsw"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails, userDetails1);
//    }

}