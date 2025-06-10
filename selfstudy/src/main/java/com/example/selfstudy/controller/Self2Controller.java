package com.example.selfstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Self2Controller {
    @GetMapping("/quote")
    public String randomQuote(Model model){
        String[] quotes = {
                "행복은 습관이다 그것을 몸에지녀라",
                "고개숙이지마세요 세상을 똑바로 정면으로",
                "고난의 시기에 쫄지마라",
                "작은기회는 작은기회일뿐이다"

        };
        int randInt = (int) (Math.random() * quotes.length);
        model.addAttribute("randomQuote", quotes[randInt]);
        return "quote";
    }
}
