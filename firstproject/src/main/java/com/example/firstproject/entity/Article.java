package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Entity //테이블로 생성
//@Table(name = "article") 테이블 이름
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //자동생성 기능 추가(숫자가 자동 증가)
    private Long id; //기본키

    @Column
    private String title;

    private String content;

    public void patch(Article article) {

        if(article.title != null){
            this.title = article.title;
        }
        if(article.content != null ){
            this.content = article.content;
        }
    }

}
