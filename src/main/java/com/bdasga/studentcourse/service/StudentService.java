package com.bdasga.studentcourse.service;

import java.util.List;

import com.bdasga.studentcourse.model.Student;


public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    Student updateStudent(Long id, Student updatedStudent);
    void deleteStudent(Long id); 
}
