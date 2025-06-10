package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String hi(Model model) {
        model.addAttribute("username", "김정명");
        return "greetings";

    }
    @GetMapping("/bye")
    public String bye(Model model) {
        model.addAttribute("nickname", "김정명");
            return "goodbye";
    }
}
