package com.example.selfstudy.repository;

import com.example.selfstudy.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository  extends CrudRepository<Article,Long> {
    List<Article> findAll();
}
