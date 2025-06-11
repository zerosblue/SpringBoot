package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }
    public Article show(@PathVariable Long id) {
      log.info("1-------------------------");
      articleRepository.findById(id).ifPresent(article -> {});
      log.info("2-------------------------");
      Article article = articleRepository.findById(id).orElse(null);
      log.info("3-------------------------");
      return article;
    }
    //create - insert sql 실행
    public Article create(@RequestBody ArticleForm dto) {

        Article article = dto.toEntity();
        return articleRepository.save(article);

    }
    //update -update sql 실행
    public Article update(@PathVariable Long id, @RequestBody ArticleForm dto) {


        //1. Dto -> entity 변환
        Article article = dto.toEntity();

        //2. 타닛 조회하기
        Article target = articleRepository.findById(id).orElse(null);

        //3. 잘못된 요청 처리하기
            if(target == null || id != article.getId()){
            log.info("id : {} ,article :{}", id, article.getId());
            return null;
        }
            log.info("update article :{}", article);

        //4. update 및 정상 응답하기
            target.patch(article);
            return articleRepository.save(target);

    }

    public Article delete(Long id) {
        articleRepository.deleteById(id);

        //1. 대상찾기
        Article target = articleRepository.findById(id).orElse(null);

        //2. 잘못된요청 처리하기
        if(target == null){
            return null;
        }

        //3.대상삭제하기
        articleRepository.delete(target);
        return null;
    }
}
