package com.example.Firstproject.Repository;

import com.example.Firstproject.entity.Article;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository  extends CrudRepository<Article, Long> {

    @Override
    ArrayList<Article> findAll();


}
