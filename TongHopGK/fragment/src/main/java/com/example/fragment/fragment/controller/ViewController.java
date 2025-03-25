package com.example.fragment.fragment.controller;

import com.example.fragment.fragment.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {
    private List<Student> students = new ArrayList<>();


    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/list")
    public String showStudentList(Model model) {
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/addNew")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addNew";
    }

    @PostMapping("/addNew")
    public String addStudent(@ModelAttribute Student student) {
        students.add(student);
        return "redirect:/list";
    }


}
