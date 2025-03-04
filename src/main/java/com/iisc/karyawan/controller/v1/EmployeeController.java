package com.iisc.karyawan.controller.v1;

import com.iisc.karyawan.constant.Constant;
import com.iisc.karyawan.dto.request.EmployeeRequest;
import com.iisc.karyawan.dto.response.EmployeeResponse;
import com.iisc.karyawan.service.EmployeeService;
import com.iisc.karyawan.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(Constant.EMPLOYEE_API)
public class EmployeeController {
    
    private final EmployeeService employeeService;
    
    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        EmployeeResponse employeeResponse = employeeService.saveEmployee(employeeRequest);
        
        return ResponseUtil.buildResponse(HttpStatus.CREATED, Constant.SUCCESS_CREATE_EMPLOYEE, employeeResponse);
    }
}
