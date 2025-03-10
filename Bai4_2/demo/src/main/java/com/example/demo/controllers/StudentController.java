package com.example.demo.controllers;

import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String showStudents(Model model) {
        List<Student> students = Arrays.asList(
                new Student("SV001", "Nguyen Van A", 2000, "Nam"),
                new Student("SV002", "Tran Thi B", 2001, "Nữ"),
                new Student("SV003", "Le Van C", 1999, "Nam")
        );

        model.addAttribute("students", students);
        return "students";
    }
}
