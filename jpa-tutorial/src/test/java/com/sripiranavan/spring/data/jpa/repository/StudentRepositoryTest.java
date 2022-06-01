package com.sripiranavan.spring.data.jpa.repository;

import com.sripiranavan.spring.data.jpa.entity.Guardian;
import com.sripiranavan.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("sri@gmail.com")
                .firstName("Sripiranavan")
                .lastName("Yogarajah")
//                .guardianName("Indirani")
//                .guardianEmail("indirani@gmail.com")
//                .guardianMobile("0774050501")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Vynthi")
                .email("vynthi@gmail.com")
                .mobile("0775241789")
                .build();

        Student student = Student.builder()
                .firstName("Sripiranavan")
                .lastName("Yogarajah")
                .emailId("sripiranavan@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Sripiranavan");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Sri");
        System.out.println(students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Vynthi");
        System.out.println(students);
    }

    @Test
    public void printgetStudentEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("sripiranavan@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentFirstNameFromEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("sripiranavan@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void printgetStudentEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("sripiranavan@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentEmailAddressNativeParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeParam("sripiranavan@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Yogarajah","sripiranavan@gmail.com");
    }
}