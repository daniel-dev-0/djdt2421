package com.djdt2421.repo;

import com.djdt2421.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
    User findByPsw(String psw);
}
