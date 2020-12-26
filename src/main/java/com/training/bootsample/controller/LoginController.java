package com.training.bootsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam(required = false, defaultValue = "false") boolean error) {
        model.addAttribute("error", error);
        return "login";
    }
}
