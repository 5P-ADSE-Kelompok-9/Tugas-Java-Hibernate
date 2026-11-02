# Tugas Java Hibernate & Spring Boot - Sistem Registrasi dan Login

Proyek ini adalah aplikasi web sederhana berbasis Java menggunakan kerangka kerja **Spring Boot**, **Spring Data JPA (Hibernate)**, dan basis data **PostgreSQL**. Aplikasi ini menyediakan fitur pendaftaran (registrasi) akun, masuk (login), dan halaman dashboard setelah autentikasi berhasil dengan antarmuka **JSP (JavaServer Pages)**.

## Fitur Utama
- **Registrasi Akun:** Pengguna dapat mendaftarkan akun baru dengan memasukkan username dan password. Validasi mendeteksi jika username sudah terdaftar sebelumnya.
- **Login Sistem:** Pengguna dapat masuk menggunakan kredensial yang telah didaftarkan.
- **Dashboard:** Halaman selamat datang eksklusif setelah pengguna berhasil login.
- **Manajemen Basis Data Otomatis:** Menggunakan Hibernate ORM untuk pembuatan dan pembaruan tabel basis data secara otomatis (`ddl-auto=update`).

## Teknologi yang Digunakan
- **Java JDK** (Versi 17 atau 21 LTS)
- **Spring Boot** (Versi 3.x / 4.x)
- **Spring Data JPA / Hibernate**
- **PostgreSQL** (Basis Data Relasional)
- **Apache Tomcat / Jasper & JSTL** (Untuk pemrosesan file JSP)
- **Maven** (Manajemen Dependensi)

## Struktur Direktori Proyek
```text
demo-jpa/
│
├── src/
│   ├── main/
│   │   ├── java/org/team9/demojpa/
│   │   │   ├── controller/      # Pengatur rute dan logika halaman (AuthController)
│   │   │   ├── entity/          # Model tabel basis data (User)
│   │   │   ├── repository/      # Antarmuka komunikasi database (UserRepository)
│   │   │   └── DemoJpaApplication.java
│   │   │
│   │   ├── resources/
│   │   │   └── application.properties # Konfigurasi database dan server
│   │   │
│   │   └── webapp/WEB-INF/views/
│   │       ├── register.jsp     # Form pendaftaran akun
│   │       ├── login.jsp        # Form masuk aplikasi
│   │       └── dashboard.jsp    # Halaman utama setelah login
│   │
│   └── test/
│
├── pom.xml                      # Konfigurasi Maven dan dependensi
└── README.md
```

## Panduan Instalasi dan Menjalankan Program

### 1. Persiapan Basis Data PostgreSQL
Buka pgAdmin atau klien PostgreSQL Anda, lalu buat database baru dengan nama:
```sql
CREATE DATABASE telesko;
```

### 2. Konfigurasi Proyek
Sesuaikan informasi koneksi database pada file `src/main/resources/application.properties` jika diperlukan (atur username dan password sesuai dengan pengaturan lokal Anda):
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/telesko
spring.datasource.username=postgres
spring.datasource.password=0000

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8093

spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```

### 3. Menjalankan Aplikasi
Buka terminal pada direktori proyek Anda, lalu jalankan perintah Maven berikut:
```bash
mvnw clean spring-boot:run
```
*(Atau Anda bisa langsung mengeklik tombol Run pada class utama `DemoJpaApplication` di IntelliJ IDEA).*

### 4. Mengakses Aplikasi
Buka peramban web (browser) dan akses alamat berikut:
- Halaman Registrasi: `http://localhost:8093/register`
- Halaman Login: `http://localhost:8093/login`

## Kelompok 9 - 5P ADSE
- Muhammad Fayaz Irham - 033
- Muhamad Dimas Saputra - 035
- Rizki Febrian - 073 
