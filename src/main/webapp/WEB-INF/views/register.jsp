<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registrasi User</title>
</head>
<body>
<h2>Form Registrasi</h2>
<p style="color:red;">${error}</p>
<form action="/register" method="POST">
    <label>Username:</label><br>
    <input type="text" name="username" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <button type="submit">Daftar</button>
</form>
<br>
<a href="/login">Sudah punya akun? Login di sini</a>
</body>
</html>