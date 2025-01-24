package com.djdt2421.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Entity
public class User {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idUser;

    @Column(unique = true,nullable = false)
    String userName;

    @Column(nullable = false)
    String psw;

    @ManyToMany
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Roles> roles;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser && Objects.equals(userName, user.userName) && Objects.equals(psw, user.psw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, userName, psw);
    }


}
