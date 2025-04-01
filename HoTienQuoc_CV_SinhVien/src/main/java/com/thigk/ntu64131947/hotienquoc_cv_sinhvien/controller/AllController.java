package com.thigk.ntu64131947.hotienquoc_cv_sinhvien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }


}
