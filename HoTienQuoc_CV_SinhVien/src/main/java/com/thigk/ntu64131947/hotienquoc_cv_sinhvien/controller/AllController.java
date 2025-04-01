package com.thigk.ntu64131947.hotienquoc_cv_sinhvien.controller;

import com.thigk.ntu64131947.hotienquoc_cv_sinhvien.model.Student;
import com.thigk.ntu64131947.hotienquoc_cv_sinhvien.model.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AllController {
    List<Topic> topics;
    List<Student> students;

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "index";
    }

    @GetMapping("/topic/all")
    public String allTopics(Model model) {
        model.addAttribute("topics", topics);
        return "topicAll";
    }

    @PostMapping("/topic/new")
    public String newTopic(@ModelAttribute("topic") Topic topic) {
        topics.add(topic);
        return "redirect:/topicAll";
    }

    @GetMapping("/topic/view/id")
    public String viewTopic(@RequestParam("id") int id, Model model) {
        model.addAttribute("topic", topics.get(id));
        return "viewIdTopic";
    }

    @PostMapping("/topic/delete/id")
    public String deleteTopic(@RequestParam("id") int id) {
        topics.remove(id);
        return "redirect:/topicAll";
    }


    @GetMapping("/student/all")
    public String allStudents(Model model) {
        model.addAttribute("students", students);
        return "studentAll";
    }

    @PostMapping("/student/new")
    public String newStudent(@ModelAttribute("student") Student student) {
        students.add(student);
        return "redirect:/studentAll";
    }

    @GetMapping("/student/view/id")
    public String viewStudent(@RequestParam("id") int id, Model model) {
        model.addAttribute("student", students.get(id));
        return "viewIdStudent";
    }

    @PostMapping("/student/delete/id")
    public String deleteStudent(@RequestParam("id") int id) {
        students.remove(id);
        return "redirect:/studentAll";
    }





}
