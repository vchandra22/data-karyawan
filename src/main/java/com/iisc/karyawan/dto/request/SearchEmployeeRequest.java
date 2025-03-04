package com.iisc.karyawan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SearchEmployeeRequest extends PagingRequest {
    private String fullName;
    private String gender;
    private String address;
    private String nationality;
}
