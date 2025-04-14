package com.hotienquoc.cv.sinhvien.hotienquoc_cv_sinhvien.controllers.topics;

import com.hotienquoc.cv.sinhvien.hotienquoc_cv_sinhvien.models.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/topic")
public class TopicController {
    private static List<Topic> topics = new ArrayList<>();
    private static long topicIdCounter = 1L;

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("topic", new Topic(null, "", "", "", ""));
        model.addAttribute("content", "topic/new");
        return "layout/main";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute Topic topic) {
        topic.setId(topicIdCounter++);
        topics.add(topic);
        return "redirect:/topic/all";
    }

    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("topics", topics);
        model.addAttribute("content", "topic/all");
        return "layout/main";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Topic topic = topics.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (topic != null) {
            model.addAttribute("topic", topic);
        }
        model.addAttribute("content", "topic/view");
        return "layout/main";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        topics.removeIf(t -> t.getId().equals(id));
        return "redirect:/topic/all";
    }
}
