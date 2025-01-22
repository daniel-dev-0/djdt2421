package com.djdt2421.service;

import com.djdt2421.entities.Student;
import com.djdt2421.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> showAllStudents() {
        return studentRepository.findAll();
    }

    public Student showStudentByID(int idStudent) {
        return studentRepository.findById(idStudent).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void createNewStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudentById(int idStudent, Student student){
        student.setIdStudent(idStudent);
        studentRepository.save(student);
    }

    public void deleteStudentByID(int idStudent) {
        studentRepository.deleteById(idStudent);
    }
}
