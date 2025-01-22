package com.djdt2421.entities;

import jakarta.persistence.*;

@Entity
public class Courses {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCourse;
    @Column(nullable = false)
    String courseName;

    @Column(nullable = false)
    int hours;
//    @Column( updatable=false)
//    int studentId;
//
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student studentForID;


    public Student getStudentForID() {
        return studentForID;
    }

    public void setStudentForID(Student studentForID) {
        this.studentForID = studentForID;
    }

    public Courses() {
    }

    public Courses(int idCourse, String courseName, int hours, int idStudent) {
        this.idCourse = idCourse;
        this.courseName = courseName;
        this.hours = hours;

    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


}
