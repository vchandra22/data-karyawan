package com.iisc.karyawan.dto.request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {
    private String nik;
    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String nationality;
}
