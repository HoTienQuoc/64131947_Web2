package com.hotienquoc.cv.sinhvien.hotienquoc_cv_sinhvien.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Controllers {

    @GetMapping
    public String home(Model model) {
        // Đảm bảo trang chủ sẽ hiển thị layout với nội dung cụ thể, ví dụ "student/all"
        model.addAttribute("content", "index"); // Hoặc bất kỳ trang nào bạn muốn làm trang chủ
        return "layout/main"; // Trả về layout với content được xác định
    }
}
