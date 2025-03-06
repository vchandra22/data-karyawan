# RESTful API Documentation

## Overview

API ini digunakan untuk mengelola data karyawan dengan database PostgreSQL.

## Configuration

Pastikan Anda mengupdate konfigurasi database di `application.properties`:

```properties
server.port=8080
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/tabel_karyawan
spring.datasource.username=postgres
spring.datasource.password=postgres
```

## API Endpoint

### 1. Create Employee

**Endpoint:**

```
POST /api/v1/employees
```

**Request Body:**

```json
{
   "nik": "3505180433999993",
   "fullName": "John Doe",
   "dateOfBirth": "2000-03-11",
   "gender": "L",
   "address": "103 Main Street, Malang",
   "nationality": "Indonesia"
}
```

**Response:**

```json
{
   "status": 201,
   "message": "Successfully created employee",
   "data": {
      "id": "6f546b22-a7c7-46f1-ba74-aabf0e639534",
      "nik": "3505180433999993",
      "fullName": "John Doe",
      "dateOfBirth": "2000-03-11T00:00:00.000+00:00",
      "gender": "L",
      "address": "103 Main Street, Malang",
      "nationality": "Indonesia"
   },
   "paging": null
}
```

### 2. Get All Employees

**Endpoint:**

```
GET /api/v1/employees
```

**Query Parameters:**

- `page` (optional, default: 1) - Halaman data yang ingin diambil.
- `size` (optional, default: 10) - Jumlah data per halaman.
- `nik` (optional) - Filter berdasarkan nik.
- `fullName` (optional) - Filter berdasarkan nama lengkap.
- `address` (optional) - Filter berdasarkan alamat.
- `gender` (optional) - Filter berdasarkan jenis kelamin.
- `nationality` (optional) - Filter berdasarkan kewarganegaraan.

**Response:**

```json
{
   "status": 200,
   "message": "Successfully get all employees",
   "data": [
      {
         "id": "6f546b22-a7c7-46f1-ba74-aabf0e639534",
         "nik": "3505180433999993",
         "fullName": "John Doe",
         "dateOfBirth": "2000-03-11",
         "gender": "L",
         "address": "103 Main Street, Malang",
         "nationality": "Indonesia"
      }
   ],
   "paging": {
      "page": 1,
      "size": 10,
      "totalPage": 1,
      "totalItems": 1
   }
}
```

### 3. Get Employee by ID

**Endpoint:**

```
GET /api/v1/employees/{id}
```

**Path Parameter:**

- `id` (required) - ID karyawan yang ingin diambil.

**Response:**

```json
{
   "status": 200,
   "message": "Successfully get all employees",
   "data": {
      "id": "6f546b22-a7c7-46f1-ba74-aabf0e639534",
      "nik": "3505180433999993",
      "fullName": "John Doe",
      "dateOfBirth": "2000-03-11",
      "gender": "L",
      "address": "103 Main Street, Malang",
      "nationality": "Indonesia"
   },
   "paging": null
}
```

### 4. Update Employee

**Endpoint:**

```
PUT /api/v1/employees/{id}
```

**Path Parameter:**

- `id` (required) - ID karyawan yang ingin diperbarui.

**Request Body:**

```json
{
   "nik": "3505180433999995",
   "fullName": "John Doe",
   "dateOfBirth": "2000-03-12",
   "gender": "L",
   "address": "103 Main Street, Blitar",
   "nationality": "Indonesia"
} 
```

**Response:**

```json
{
   "status": 200,
   "message": "Successfully updated employee",
   "data": {
      "id": "6f546b22-a7c7-46f1-ba74-aabf0e639534",
      "nik": "3505180433999995",
      "fullName": "John Doe",
      "dateOfBirth": "2000-03-12T00:00:00.000+00:00",
      "gender": "L",
      "address": "103 Main Street, Blitar",
      "nationality": "Indonesia"
   },
   "paging": null
}
```

### 5. Delete Employee

**Endpoint:**

```
DELETE /api/v1/employees/{id}
```

**Path Parameter:**

- `id` (required) - ID karyawan yang ingin dihapus.

**Response:**

```json
{
  "status": 200,
  "message": "Successfully deleted employee",
  "data": null
}
```

## Running the Application

1. Pastikan PostgreSQL sudah terinstall dan dikonfigurasi dengan benar.
2. Jalankan perintah berikut:
```sh
mvn clean instal
```
3. Jalankan aplikasi menggunakan perintah berikut:
   ```sh
   mvn spring-boot:run
   ```
4. API akan tersedia di `http://localhost:8080`.

## Notes

- Pastikan PostgreSQL sudah berjalan sebelum menjalankan aplikasi.
- Buka file application.properties dan sesuaikan konfigurasi sesuai dengan pengaturan database Anda.
- Gunakan tool seperti Postman untuk menguji endpoint.

---

