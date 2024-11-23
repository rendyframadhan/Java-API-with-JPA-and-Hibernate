package com.technicaltest.fruitservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @PostMapping("/test/login")
    public String showLoginPage(Model model) {
        return "login";
    }
}
