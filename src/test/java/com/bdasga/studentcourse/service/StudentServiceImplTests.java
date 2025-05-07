package com.bdasga.studentcourse.service;

import com.bdasga.studentcourse.model.Student;
import com.bdasga.studentcourse.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceImplTests {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveStudent() {
        Student student = new Student();
        student.setId(1L);
        student.setName("Sagnik Dey");

        when(studentRepository.save(student)).thenReturn(student);

        Student saved = studentService.saveStudent(student);
        assertEquals("Sagnik Dey", saved.getName());
    }

    @Test
    void testGetStudentById() {
        Student student = new Student();
        student.setId(1L);

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student found = studentService.getStudentById(1L);
        assertNotNull(found);
        assertEquals(1L, found.getId());
    }

    @Test
    void testUpdateStudent() {
        Student student = new Student();
        student.setId(1L);
        student.setName("Updated");

        when(studentRepository.save(student)).thenReturn(student);
        Student updated = studentService.updateStudent(1L, student);

        assertEquals("Updated", updated.getName());
    }
}
