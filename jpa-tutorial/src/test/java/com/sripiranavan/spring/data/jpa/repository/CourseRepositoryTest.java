package com.sripiranavan.spring.data.jpa.repository;

import com.sripiranavan.spring.data.jpa.entity.Course;
import com.sripiranavan.spring.data.jpa.entity.Student;
import com.sripiranavan.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void printCourses() {
        List<Course> courses = repository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Priya")
                .lastName("Sri")
                .build();
        Course course = Course.builder()
                .title("python")
                .credit(6)
                .teacher(teacher)
                .build();

        repository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
        List<Course> courses = repository.findAll(firstPageWithThreeRecords)
                .getContent();

        Long totalElements = repository.findAll(firstPageWithThreeRecords)
                .getTotalElements();

        Long totalPages = Long.valueOf(repository.findAll(firstPageWithThreeRecords)
                .getTotalPages());
        System.out.println("totalElements: " + totalElements);

        System.out.println("totalPages: " + totalPages);

        System.out.println("Courses = " + courses);
    }

    @Test
    public void findAllSorting() {

    Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
    Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
    Pageable sortByTitleAndCredit = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

    List<Course> courses = repository.findAll(sortByCreditDesc)
            .getContent();
        System.out.println(courses);
    }

    @Test
    public void findByTitleContainingTest(){
        Pageable firstPageTenRecords = PageRequest.of(0,10);

        List<Course> courses = repository.findByTitleContaining("D",firstPageTenRecords)
                .getContent();

        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);
        repository.save(course);
    }
}