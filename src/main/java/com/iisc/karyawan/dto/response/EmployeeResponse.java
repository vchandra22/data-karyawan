package com.iisc.karyawan.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
    private String id;
    private String fullName;
    private String gender;
    private String address;
    private String nationality;
}
