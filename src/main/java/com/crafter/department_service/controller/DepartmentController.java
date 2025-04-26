package com.crafter.department_service.controller;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crafter.department_service.client.EmployeeClient;
import com.crafter.department_service.model.Department;
import com.crafter.department_service.repo.DepartmentRepository;
import com.crafter.department_service.services.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeeClient empClient;
	
	@GetMapping(value="")
	public String testController() {
		return "Department Controller";
	}
	
	@PostMapping(value="/add")
	public Department add(@RequestBody Department department) {
		LOGGER.info("Department added : {}", department);
		return departmentService.addDepartment(department);
	}
	
	@GetMapping(value="/getAllDepartments")
	public List<Department> getAllDepartments(){
		LOGGER.info("Department Find all");
		return null;//departmentRepo.findAllDepartments();
	}
	
	@GetMapping(value="/getDepartmentById")
	public Department findById(@RequestParam Long id){
		LOGGER.info("Department Find by id");
		return null;//departmentRepo.findById(id);
	}
	/*
	@GetMapping(value="/getAllDepartmentsWithEmployees")
	public List<Department> getAllDepartmentsWithEmployees(){
		LOGGER.info("Department Find all departments With Employees");
		List<Department> departments = departmentRepo.findAllDepartments();
		departments.forEach(
				department-> department.setEmployees(empClient.getEmployeeByDepartmentId(department.getId())));
		return departments;
	}*/

}
