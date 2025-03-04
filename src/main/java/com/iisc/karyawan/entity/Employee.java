package com.iisc.karyawan.entity;

import com.iisc.karyawan.constant.Constant;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@Entity
@Table(name = Constant.EMPLOYEE_TABLE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;
    
    @Column(name = "full_name")
    private String fullName;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "nationality")
    private String nationality;
}
