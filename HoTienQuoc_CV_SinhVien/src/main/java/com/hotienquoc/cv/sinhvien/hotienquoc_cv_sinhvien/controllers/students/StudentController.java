package com.hotienquoc.cv.sinhvien.hotienquoc_cv_sinhvien.controllers.students;

import com.hotienquoc.cv.sinhvien.hotienquoc_cv_sinhvien.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private static List<Student> students = new ArrayList<>();
    private static long studentIdCounter = 1L;

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("student", new Student(0, "", ""));
        model.addAttribute("content", "student/new");
        return "layout/main";
    }



    @PostMapping("/new")
    public String add(@ModelAttribute Student student) {
        student.setId(studentIdCounter++);
        students.add(student);
        return "redirect:/student/all";
    }

    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("students", students);
        model.addAttribute("content", "student/all");
        return "layout/main";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Student student = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if (student != null) {
            model.addAttribute("student", student);
        }

        model.addAttribute("content", "student/view");
        return "layout/main";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        students.removeIf(s -> s.getId() == id);
        return "redirect:/student/all";
    }
}
