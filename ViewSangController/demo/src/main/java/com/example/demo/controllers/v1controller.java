package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class v1controller {
    @GetMapping("/v1")
    public String home() {
        return "v1";
    }

    @PostMapping("/v1")
    public String v1(@RequestParam ("hoten") String name, Model model) {
        if (name.isEmpty()) {
            return "v1";
        } else {
            model.addAttribute("hoten", name);
            return "ketquav1";
        }
    }
}
