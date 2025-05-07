package com.bdasga.studentcourse.repository;

import com.bdasga.studentcourse.model.Course;
import com.bdasga.studentcourse.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class StudentRepositoryTests {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        // Create and save a test course
        Course course = new Course();
        course.setId("CSE101");
        course.setCourseName("Intro to Programming");
        courseRepository.save(course);

        // Create and save a student linked to the course
        Student student = new Student();
        student.setName("Alice");
        student.setEmail("alice@example.com");
        student.setCourse(course);
        studentRepository.save(student);
    }

    @Test
    void testFindStudentsByCourseName() {
        List<Student> result = studentRepository.findStudentsByCourseName("Intro to Programming");
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    void testFindStudentsByNonExistentCourse() {
        List<Student> result = studentRepository.findStudentsByCourseName("Advanced Data Science");
        assertTrue(result.isEmpty());
    }
}
