package com.iisc.karyawan.entity;

import com.iisc.karyawan.constant.Constant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

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

    @NotBlank(message = "NIK tidak boleh kosong")
    @Size(min = 16, max = 20, message = "NIK harus terdiri dari minimal 16 sampai 20 digit")
    @Column(name = "nik", nullable = false, unique = true)
    private String nik;

    @NotBlank(message = "Nama lengkap tidak boleh kosong")
    @Size(min = 3, max = 100, message = "Nama lengkap harus antara 3 hingga 100 karakter")
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Past(message = "Tanggal lahir harus di masa lalu")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @NotBlank(message = "Jenis kelamin tidak boleh kosong")
    @Pattern(regexp = "^(L|P)$", message = "Jenis kelamin harus 'L' atau 'P'")
    @Column(name = "gender", nullable = false)
    private String gender;

    @NotBlank(message = "Alamat tidak boleh kosong")
    @Size(max = 255, message = "Alamat tidak boleh lebih dari 255 karakter")
    @Column(name = "address", nullable = false)
    private String address;

    @NotBlank(message = "Kewarganegaraan tidak boleh kosong")
    @Column(name = "nationality", nullable = false)
    private String nationality;
}
