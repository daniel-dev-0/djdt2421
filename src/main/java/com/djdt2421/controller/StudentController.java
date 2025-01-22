package com.djdt2421.controller;

import com.djdt2421.entities.Student;
import com.djdt2421.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/showAllStudents")
    public List<Student> displayAllStudents() {
        return studentService.showAllStudents();
    }

    @GetMapping("/showStudentById/{idStudent}")
    public  Student dysplayStudentById(@PathVariable int idStudent){
        return  studentService.showStudentByID(idStudent);
    }


    @PostMapping("/addNewStudent")
    public  void addNewStudent(@RequestBody Student student){
        studentService.createNewStudent(student);

    }

    @PutMapping("/updateStudentById/{idStudent}")
    public void updateStudentById(@PathVariable int idStudent,@RequestBody Student student){
        studentService.updateStudentById(idStudent, student);
    }

    @DeleteMapping("deletById/{idStudent}")
    public  void  deletStudentById(@PathVariable int idStudent){
        studentService.deleteStudentByID(idStudent);
    }

}
