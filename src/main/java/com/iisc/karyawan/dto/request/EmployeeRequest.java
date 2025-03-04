package com.iisc.karyawan.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {
    private String fullName;
    private String gender;
    private String address;
    private String nationality;
}
