package com.sripiranavan.spring.controller;

import com.sripiranavan.spring.entity.Department;
import com.sripiranavan.spring.error.DepartmentNotFoundException;
import com.sripiranavan.spring.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping(path = "/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside save department of department controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping(path = "/departments")
    public List<Department> fetchDepartments(){
        LOGGER.info("Inside fetch departments of department controller");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping(path = "/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping(path = "/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";
    }

    @PutMapping(path = "/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping(path = "/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
