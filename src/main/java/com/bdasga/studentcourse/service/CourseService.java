package com.bdasga.studentcourse.service;

import java.util.List;

import com.bdasga.studentcourse.model.Course;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(String id);

    Course saveCourse(Course course);

    Course updateCourse(String id, Course updatedCourse);

    void deleteCourse(String id); 
}