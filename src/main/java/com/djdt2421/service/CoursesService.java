package com.djdt2421.service;

import com.djdt2421.entities.Courses;
import com.djdt2421.entities.Student;
import com.djdt2421.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    CourseRepository courseRepository;

    public List<Courses> showAllCourses() {
        return courseRepository.findAll();
    }


    public Courses showCourseByID(int idCourse) {
        return courseRepository.findById(idCourse).orElseThrow(() -> new RuntimeException("Course not found"));
    }
    public void createNewCourse(Courses courses) {
        courseRepository.save(courses);
    }

    public void updateCourseById(int idCourse, Courses courses){
        courses.setIdCourse(idCourse);
        courseRepository.save(courses);
    }

    public void deleteCourseByID(int idCourse) {
        courseRepository.deleteById(idCourse);
    }

}
