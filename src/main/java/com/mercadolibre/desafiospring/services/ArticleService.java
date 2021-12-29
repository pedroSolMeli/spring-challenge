package com.mercadolibre.desafiospring.services;

import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public List<Article> findAll() {
        return repository.getArticles();
    }
}
