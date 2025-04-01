package com.thigk.ntu64131947.hotienquoc_cv_sinhvien.controller;

import com.thigk.ntu64131947.hotienquoc_cv_sinhvien.model.Student;
import com.thigk.ntu64131947.hotienquoc_cv_sinhvien.model.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID; // Để tạo ID String ngẫu nhiên

@Controller
public class AllController {

    // Lưu trữ dữ liệu tạm thời trong bộ nhớ - Thay thế bằng DB trong ứng dụng thực tế
    private final List<Topic> topics = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    // --- General ---
    @GetMapping("/")
    public String home() {
        return "index"; // Renders templates/index.html
    }

    // --- Topic Management ---

    @GetMapping("/topic/all")
    public String listTopics(Model model) {
        model.addAttribute("topics", topics);
        return "topic/all"; // Renders templates/topic/list.html
    }

    @GetMapping("/topic/add")
    public String showAddTopicForm(Model model) {
        model.addAttribute("topic", new Topic()); // Cần đối tượng rỗng để binding form
        return "topic/add"; // Renders templates/topic/add.html
    }

    @PostMapping("/topic/add")
    public String addTopic(@ModelAttribute("topic") Topic topic) {
        // Tạo ID nếu người dùng không nhập (hoặc form không có trường ID)
        if (topic.getId() == null || topic.getId().trim().isEmpty()) {
            topic.setId(UUID.randomUUID().toString().substring(0, 8)); // Tạo ID String ngẫu nhiên ngắn
        }
        topics.add(topic);
        return "redirect:/topic/all"; // Chuyển hướng về trang danh sách
    }

    @GetMapping("/topic/view/{id}")
    public String viewTopic(@PathVariable("id") String id, Model model) {
        Topic foundTopic = topics.stream()
                .filter(t -> id.equals(t.getId())) // So sánh String ID
                .findFirst()
                .orElse(null);
        if (foundTopic != null) {
            model.addAttribute("topic", foundTopic);
            return "topic/view"; // Renders templates/topic/view.html
        }
        return "redirect:/topic/all"; // Không tìm thấy thì về trang list
    }

    @PostMapping("/topic/delete/{id}")
    public String deleteTopic(@PathVariable("id") String id) {
        topics.removeIf(t -> id.equals(t.getId())); // Xóa theo String ID
        return "redirect:/topic/all";
    }

    // --- Student Management ---

    @GetMapping("/student/all")
    public String listStudents(Model model) {
        model.addAttribute("students", students);
        return "student/all"; // Renders templates/student/list.html
    }

    @GetMapping("/student/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student()); // Cần đối tượng rỗng để binding form
        return "student/add"; // Renders templates/student/add.html
    }

    @PostMapping("/student/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        // Tạo ID nếu người dùng không nhập
        if (student.getId() == null || student.getId().trim().isEmpty()) {
            student.setId(UUID.randomUUID().toString().substring(0, 8)); // Tạo ID String ngẫu nhiên ngắn
        }
        students.add(student);
        return "redirect:/student/all";
    }

    @GetMapping("/student/view/{id}")
    public String viewStudent(@PathVariable("id") String id, Model model) {
        Student foundStudent = students.stream()
                .filter(s -> id.equals(s.getId())) // So sánh String ID
                .findFirst()
                .orElse(null);
        if (foundStudent != null) {
            model.addAttribute("student", foundStudent);
            return "student/view"; // Renders templates/student/view.html
        }
        return "redirect:/student/all";
    }

    @PostMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id) {
        students.removeIf(s -> id.equals(s.getId())); // Xóa theo String ID
        return "redirect:/student/all";
    }
}