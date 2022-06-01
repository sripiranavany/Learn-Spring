package com.sripiranavan.spring.data.jpa.repository;

import com.sripiranavan.spring.data.jpa.entity.Course;
import com.sripiranavan.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher(){
        Course course1 = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course course2 = Course.builder()
                .title("JAVA")
                .credit(6)
                .build();
        Teacher teacher = Teacher.builder().
                firstName("Indirani")
                .lastName("Yogarajah")
//                .courses(List.of(course1,course2))
                .build();

        repository.save(teacher);
    }
}