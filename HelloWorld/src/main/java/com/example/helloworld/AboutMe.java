package com.example.helloworld;
import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AboutMe", value = "/AboutMe")
public class AboutMe extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>About Me</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; padding: 50px; }");
        out.println(".container { background: white; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 10px #ccc; display: inline-block; }");
        out.println("h1 { color: #333; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Thông tin cá nhân</h1>");
        out.println("<p><strong>Họ và tên:</strong> Ho Tien Quoc</p>");
        out.println("<p><strong>Ngày sinh:</strong> 02/09/2004</p>");
        out.println("<p><strong>Email:</strong> hotienquoc0429@gmail.com</p>");
        out.println("<p><strong>Sở thích:</strong> Lập trình, đọc sách, du lịch</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}