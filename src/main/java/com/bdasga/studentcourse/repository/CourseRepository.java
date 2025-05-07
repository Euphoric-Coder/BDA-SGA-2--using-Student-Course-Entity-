package com.bdasga.studentcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bdasga.studentcourse.model.Course;


public interface CourseRepository extends JpaRepository<Course, String> {
}

