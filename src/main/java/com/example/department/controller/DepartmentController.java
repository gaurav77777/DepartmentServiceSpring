package com.example.department.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;







import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	
	
	 private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	 

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
    	log.info("Request to create department: {}");
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
    	log.info("Request to get all departments");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
    	log.info("Request to get department by id: {}", id);
        return departmentService.getDepartmentById(id);
    }
}
