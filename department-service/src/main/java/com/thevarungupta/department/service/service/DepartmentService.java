package com.thevarungupta.department.service.service;

import com.thevarungupta.department.service.entity.Department;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public interface DepartmentService {
    List<Department> getAllDepartment();

    Department getDepartmentById(Long id);

    Department saveDepartment(Department department);
}
