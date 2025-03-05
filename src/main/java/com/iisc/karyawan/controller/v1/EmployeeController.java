package com.iisc.karyawan.controller.v1;

import com.iisc.karyawan.constant.Constant;
import com.iisc.karyawan.dto.request.EmployeeRequest;
import com.iisc.karyawan.dto.request.SearchEmployeeRequest;
import com.iisc.karyawan.dto.response.EmployeeResponse;
import com.iisc.karyawan.service.EmployeeService;
import com.iisc.karyawan.util.ResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.EMPLOYEE_API)
public class EmployeeController {
    
    private final EmployeeService employeeService;
    
    @PostMapping
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        EmployeeResponse employeeResponse = employeeService.saveEmployee(employeeRequest);
        
        return ResponseUtil.buildResponse(HttpStatus.CREATED, Constant.SUCCESS_CREATE_EMPLOYEE, employeeResponse);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @Valid @RequestBody EmployeeRequest employeeRequest) {
        EmployeeResponse employeeResponse = employeeService.updateEmployee(id, employeeRequest);
        
        return ResponseUtil.buildResponse(HttpStatus.OK, Constant.SUCCESS_UPDATE_EMPLOYEE, employeeResponse);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        
        return ResponseUtil.buildResponse(HttpStatus.OK, Constant.SUCCESS_DELETE_ATTENDANCE, null);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
        
        return ResponseUtil.buildResponse(HttpStatus.OK, Constant.SUCCESS_GET_ALL_EMPLOYEE, employeeResponse);
    }

    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam(name = "fullName", required = false) String fullName,
            @RequestParam(name = "gender", required = false) String gender,
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "nationality", required = false) String nationality,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size,
            @RequestParam(name = "sort", defaultValue = "fullName") String sort
    ) {
        SearchEmployeeRequest searchAttendanceRequest = SearchEmployeeRequest.builder()
                .fullName(fullName)
                .gender(gender)
                .address(address)
                .nationality(nationality)
                .page(page)
                .size(size)
                .sort(sort)
                .build();
        
        Page<EmployeeResponse> attendanceResponses = employeeService.getAllEmployees(searchAttendanceRequest);

        return ResponseUtil.buildPageResponse(HttpStatus.OK, Constant.SUCCESS_GET_ALL_EMPLOYEE, attendanceResponses);
    }
}
