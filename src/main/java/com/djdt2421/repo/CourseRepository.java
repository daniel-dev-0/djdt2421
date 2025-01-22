package com.djdt2421.repo;

import com.djdt2421.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses, Integer> {


}
