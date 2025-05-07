package com.bdasga.studentcourse;

import com.bdasga.studentcourse.model.Course;
import com.bdasga.studentcourse.model.Student;
import com.bdasga.studentcourse.repository.CourseRepository;
import com.bdasga.studentcourse.repository.StudentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class StudentcourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentcourseApplication.class, args);
    }

    // To Populate the data at start 
    @Bean
    CommandLineRunner initData(CourseRepository courseRepo, StudentRepository studentRepo) {
        return args -> {
            if (courseRepo.count() == 0 && studentRepo.count() == 0) {
                List<Course> courses = Arrays.asList(
                        new Course("CSE101", "Introduction to Programming"),
                        new Course("MTH201", "Calculus II"),
                        new Course("PHY111", "Basic Electronics"),
                        new Course("BIO123", "General Biology"),
                        new Course("CHE101", "General Chemistry"),
                        new Course("ENG210", "Writing Practice"),
                        new Course("ECO201", "Introduction to Economics"),
                        new Course("PSY110", "Introduction to Psychology"),
                        new Course("CSE303", "Database Management Systems"),
                        new Course("DA303", "Introduction to Data Analytics")
                );

                Map<String, Course> savedCourses = new HashMap<>();
                for (Course course : courses) {
                    savedCourses.put(course.getId(), courseRepo.save(course));
                }

                List<Student> students = Arrays.asList(
                        new Student("Rajveer Sinha", "rajveer.sinha@example.com", savedCourses.get("CSE303")),
                        new Student("Rohit Sarkar", "rohit.sarkar@example.com", savedCourses.get("CSE101")),
                        new Student("Ritankar Ghosh", "ritankar.ghosh@example.com", savedCourses.get("CSE303")),
                        new Student("Digvesh Rathi", "digvesh.rathi@example.com", savedCourses.get("DA303")),
                        new Student("Subhman Gill", "subhman.gill@example.com", savedCourses.get("BIO123")),
                        new Student("Jasprit Bumrah", "jasprit.bumrah@example.com", savedCourses.get("CHE101")),
                        new Student("Rahul Mondal", "rahul.mondal@example.com", savedCourses.get("CSE101")),
                        new Student("Adrian Hajdin", "adrian.hajdin@example.com", savedCourses.get("PHY111")),
                        new Student("Glenn Maxwell", "glenn.maxwell@example.com", savedCourses.get("ECO201")),
                        new Student("Ravindra Jadeja", "ravindra.jadeja@example.com", savedCourses.get("BIO123"))
                );

                studentRepo.saveAll(students);
                System.out.println("✅ Sample data initialized.");
            }
        };
    }
}
