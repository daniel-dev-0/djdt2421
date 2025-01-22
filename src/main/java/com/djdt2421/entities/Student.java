package com.djdt2421.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStudent;

    @Column(nullable = false)
    private String numeStudent;
    @Column(nullable = false)
    private String familiaStudent;
    @Column(nullable = false)
    private int grupa;


    @OneToMany(mappedBy = "studentForID", cascade = CascadeType.ALL , orphanRemoval = true)
    public List<Courses> listOfCourses= new ArrayList<>();

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNumeStudent() {
        return numeStudent;
    }

    public void setNumeStudent(String numeStudent) {
        this.numeStudent = numeStudent;
    }

    public String getFamiliaStudent() {
        return familiaStudent;
    }

    public void setFamiliaStudent(String familiaStudent) {
        this.familiaStudent = familiaStudent;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }



    public List<Courses> getListOfCourses() {
        return listOfCourses;
    }

    public void setListOfCourses(List<Courses> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }
}
