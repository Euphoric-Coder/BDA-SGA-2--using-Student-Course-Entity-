package com.bdasga.studentcourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdasga.studentcourse.model.Course;
import com.bdasga.studentcourse.repository.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(String id, Course updatedCourse) {
        updatedCourse.setId(id);
        return courseRepository.save(updatedCourse);
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}