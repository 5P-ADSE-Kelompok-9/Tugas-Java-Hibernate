package org.team9.demojpa.controller;

import org.team9.demojpa.entity.User;
import org.team9.demojpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // --- REGISTRASI ---
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // Membuka /WEB-INF/views/register.jsp
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String username,
                                  @RequestParam String password,
                                  Model model) {
        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "Username sudah terdaftar!");
            return "register";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);

        model.addAttribute("success", "Registrasi berhasil, silahkan login.");
        return "login";
    }

    // --- LOGIN ---
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Membuka /WEB-INF/views/login.jsp
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        Optional<User> foundUser = userRepository.findByUsername(username);

        if (foundUser.isPresent() && foundUser.get().getPassword().equals(password)) {
            model.addAttribute("username", username);
            return "dashboard"; // Mengarah ke dashboard.jsp
        }

        model.addAttribute("error", "Username atau password salah!");
        return "login";
    }
}