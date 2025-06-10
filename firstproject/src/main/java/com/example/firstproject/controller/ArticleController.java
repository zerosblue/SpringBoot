package com.example.firstproject.controller;


import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
    public class ArticleController {
        @Autowired
        private ArticleRepository articleRepository;

        @GetMapping("/articles/new")
        public String newArticleForm() {
            log.info("New article form");
            return "articles/new";
        }
        @PostMapping("articles/create")
        public String createArticle(ArticleForm form) {
            log.info("New article created");
            log.info("articleForm: {}", form);

            //1. DTO를 엔티티로 변환
            Article article = form.toEntity();

            //2.repository entity로 DB에 저장
            Article saved = articleRepository.save(article);
            log.info("Saved: {}", saved);
            return "redirect:/articles/" + saved.getId();

        }

    @GetMapping("articles/{id}")
    public String show(@PathVariable Long id, Model model) {
            log.info("Show article");


            //1. {id}값을 DB에서 꺼내오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //2. Entity를 -> DTO 로 변환
        //생략

        //3. view에 전달
        model.addAttribute("article", articleEntity);

        return "articles/show";

    }
    @GetMapping("articles")
    public String index(Model model) {
            //1. 모든 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll();
        articleEntityList.forEach(list -> log.info("list : {}", list));

        //2. 모델에 데이터등록하기
        model.addAttribute("articleList", articleEntityList);
        //3.뷰페이지 설정하기
        return "articles/index";
    }

    }
