package com.example.healthcare.controller;

import com.example.healthcare.model.User;
import com.example.healthcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")  // Base URL for user-related requests
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Using @GetMapping for GET requests to display the registration form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Using @PostMapping for POST requests to handle user registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/login";  // Redirect to login page after successful registration
    }

    // Using @GetMapping for GET requests to display the login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Using @PostMapping for POST requests to handle user login
    @PostMapping("/login")
    public String loginUser(@RequestParam String mobile, @RequestParam String password, Model model) {
        User user = userRepository.findByMobile(mobile);
        if (user != null && user.getPassword().equals(password)) {  // Corrected getPassword() method
            return "redirect:/patient-form";  // Success: redirect to patient form
        }
        model.addAttribute("error", "Invalid credentials");
        return "login";  // Failure: return to login page with error
    }

    // Example of @RequestMapping with both GET and POST methods
    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public String home() {
        return "home";
    }
}
