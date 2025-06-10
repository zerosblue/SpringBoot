package com.example.studycrud.controller;

import com.example.studycrud.dto.ArticleForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm(Model model) {
        return "articles/new";

    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm) {
        log.info("New article create");
        log.info("articleForm : {}",articleForm);
        return null;

    }
}
