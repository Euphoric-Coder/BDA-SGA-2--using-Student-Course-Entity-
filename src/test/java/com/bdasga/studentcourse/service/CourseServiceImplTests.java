package com.bdasga.studentcourse.service;

import com.bdasga.studentcourse.model.Course;
import com.bdasga.studentcourse.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseServiceImplTests {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCourse() {
        Course course = new Course();
        course.setId("CSE101");
        course.setCourseName("Intro to Programming");

        when(courseRepository.save(course)).thenReturn(course);

        Course saved = courseService.saveCourse(course);
        assertEquals("CSE101", saved.getId());
    }

    @Test
    void testGetCourseById() {
        Course course = new Course();
        course.setId("CSE101");

        when(courseRepository.findById("CSE101")).thenReturn(Optional.of(course));
        Course found = courseService.getCourseById("CSE101");

        assertNotNull(found);
        assertEquals("CSE101", found.getId());
    }

    @Test
    void testUpdateCourse() {
        Course course = new Course();
        course.setId("CSE101");
        course.setCourseName("Updated");

        when(courseRepository.save(course)).thenReturn(course);
        Course updated = courseService.updateCourse("CSE101", course);

        assertEquals("CSE101", updated.getId());
        assertEquals("Updated", updated.getCourseName());
    }
}
