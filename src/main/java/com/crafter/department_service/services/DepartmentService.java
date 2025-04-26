package com.crafter.department_service.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.crafter.department_service.entity.DepartmentEntity;
import com.crafter.department_service.model.Department;
import com.crafter.department_service.repo.DepartmentRepository;

@Service
public class DepartmentService {
	
	private final DepartmentRepository jpaRepo;
	
	public DepartmentService(DepartmentRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }
	
	public Department addDepartment(Department department) {
        DepartmentEntity entity = new DepartmentEntity();
        entity.setDepartmentName(department.getName());

        DepartmentEntity saved = jpaRepo.save(entity);

        // Set ID from saved entity
        department.setId(saved.getDepartmentId());
        return department;
    }
	
	public Department findById(Long id) {
        DepartmentEntity entity = jpaRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Department not found"));
        
        return new Department(entity.getDepartmentId(), entity.getDepartmentName());
    }

    public List<Department> findAllDepartments() {
        return jpaRepo.findAll().stream()
            .map(entity -> new Department(entity.getDepartmentId(), entity.getDepartmentName()))
            .collect(Collectors.toList());
    }

}
