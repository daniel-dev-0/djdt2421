package com.djdt2421.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSec) throws Exception {
        httpSec.authorizeHttpRequests(authorizerequest ->
                        authorizerequest
                                .requestMatchers("/showAllCourses").hasRole("ADMIN")
                                .requestMatchers("/showStudentById/{idStudent}").hasRole("USER")
                                .requestMatchers("addNewCourse/{studentId}").permitAll()
                                .requestMatchers("addNewStudent/").permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable()); // Optional: only if required
        return httpSec.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails userDetails = User.withUsername("Valera")
                .password(passwordEncoder.encode("Valera1"))
                .roles("USER")
                .build();
        UserDetails userDetails1 = User.withUsername("Admin")
                .password(passwordEncoder.encode("AdminPsw"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails, userDetails1);
    }
}