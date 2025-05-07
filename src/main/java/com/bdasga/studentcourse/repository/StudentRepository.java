package com.bdasga.studentcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bdasga.studentcourse.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s JOIN s.course c WHERE c.courseName = :courseName")
    List<Student> findStudentsByCourseName(@Param("courseName") String courseName);
}
