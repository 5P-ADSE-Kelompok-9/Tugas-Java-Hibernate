<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login User</title>
</head>
<body>
<h2>Form Login</h2>
<p style="color:red;">${error}</p>
<p style="color:green;">${success}</p>
<form action="/login" method="POST">
    <label>Username:</label><br>
    <input type="text" name="username" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <button type="submit">Masuk</button>
</form>
<br>
<a href="/register">Belum punya akun? Daftar di sini</a>
</body>
</html>