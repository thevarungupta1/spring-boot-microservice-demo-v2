package com.thevarungupta.employee.service.payload;

import com.thevarungupta.employee.service.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDepartment {
    private Department department;
    private Employee employee;
}
