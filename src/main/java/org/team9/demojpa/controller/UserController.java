package org.team9.demojpa.controller;

import org.team9.demojpa.entity.User;
import org.team9.demojpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Registrasi gagal: Username sudah terdaftar!";
        }
        userRepository.save(user);
        return "Registrasi berhasil!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser.isPresent() && foundUser.get().getPassword().equals(user.getPassword())) {
            return "Login berhasil! Selamat datang, " + user.getUsername();
        }
        return "Login gagal: Username atau password salah.";
    }
}