package com.djdt2421.controller;

import com.djdt2421.entities.Courses;
import com.djdt2421.entities.Student;
import com.djdt2421.service.CoursesService;
import com.djdt2421.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @Autowired
    StudentService studentService;

    @GetMapping("/showAllCourses")
    public List<Courses> displayAllCourses() {
        return coursesService.showAllCourses();
    }

    @GetMapping("/showCoursesById/{idCourses}")
    public  Courses dysplayCourseById(@PathVariable int idCourses){
        return  coursesService.showCourseByID(idCourses);
    }

    @PostMapping("/addNewCourse/{studentId}")
    public  void addNewCourse(@RequestBody Courses courses, @PathVariable int studentId){
        Student student = studentService.showStudentByID(studentId);
        courses.setStudentForID(student);
        coursesService.createNewCourse(courses);

    }


    @PutMapping("/updateCourseById/{idCourse}")
    public void updateCourseById(@PathVariable int idCourse,@RequestBody Courses courses){
        coursesService.updateCourseById(idCourse, courses);
    }

    @DeleteMapping("deletById/{idCourse}")
    public  void  deletCourseById(@PathVariable int idCourse){
        coursesService.deleteCourseByID(idCourse);
    }


}
