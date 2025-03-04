package com.iisc.karyawan.service;

import com.iisc.karyawan.dto.request.EmployeeRequest;
import com.iisc.karyawan.dto.response.EmployeeResponse;
import com.iisc.karyawan.entity.Employee;

public interface EmployeeService {
    EmployeeResponse getEmployeeById(String id);
    EmployeeResponse getAllEmployees();
    Employee getOne(String id);
    EmployeeResponse updateEmployee(String id, EmployeeRequest  employeeRequest);
    EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);
    void deleteEmployee(String id);
}
