package com.iisc.karyawan.service;

import com.iisc.karyawan.dto.request.EmployeeRequest;
import com.iisc.karyawan.dto.request.SearchEmployeeRequest;
import com.iisc.karyawan.dto.response.EmployeeResponse;
import com.iisc.karyawan.entity.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {
    EmployeeResponse getEmployeeById(String id);
    Page<EmployeeResponse> getAllEmployees(SearchEmployeeRequest searchEmployeeRequest);
    Employee getOne(String id);
    EmployeeResponse updateEmployee(String id, EmployeeRequest  employeeRequest);
    EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);
    void deleteEmployee(String id);
}
