package com.iisc.karyawan.service.impl;

import com.iisc.karyawan.constant.Constant;
import com.iisc.karyawan.dto.request.EmployeeRequest;
import com.iisc.karyawan.dto.response.EmployeeResponse;
import com.iisc.karyawan.entity.Employee;
import com.iisc.karyawan.repository.EmployeeRepository;
import com.iisc.karyawan.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse getEmployeeById(String id) {
        Employee employee = getOne(id);
        
        return toEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse getAllEmployees() {
        return null;
    }

    @Override
    public Employee getOne(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constant.ERROR_EMPLOYEE_NOT_FOUND));
    }

    @Override
    public EmployeeResponse updateEmployee(String id, EmployeeRequest employeeRequest) {
        Employee currentEmployee = getOne(id);
        
        currentEmployee.setId(id);
        currentEmployee.setFullName(employeeRequest.getFullName());
        currentEmployee.setGender(employeeRequest.getGender());
        currentEmployee.setAddress(employeeRequest.getAddress());
        currentEmployee.setNationality(employeeRequest.getNationality());
        employeeRepository.save(currentEmployee);
        
        return toEmployeeResponse(currentEmployee);
    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .fullName(employeeRequest.getFullName())
                .gender(employeeRequest.getGender())
                .address(employeeRequest.getAddress())
                .nationality(employeeRequest.getNationality())
                .build();
        
        employeeRepository.saveAndFlush(employee);
        return toEmployeeResponse(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        Employee employee = getOne(id);
        
        employeeRepository.delete(employee);
    }
    
    private EmployeeResponse toEmployeeResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        
        employeeResponse.setId(employee.getId());
        employeeResponse.setFullName(employee.getFullName());
        employeeResponse.setGender(employee.getGender());
        employeeResponse.setAddress(employee.getAddress());
        employeeResponse.setNationality(employee.getNationality());
        
        return employeeResponse;
    }
}
