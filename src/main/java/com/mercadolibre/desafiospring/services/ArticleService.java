package com.mercadolibre.desafiospring.services;

import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    //Cria um article
    public Article createArticle(Article article){
        return repository.createArticle(article);
    }

    //Busca todos Articles em uma lista
    public List<Article> findAll() {
        return repository.getArticles();
    }

    //Busca os Articles por categoria
    public List<Article> findCategory() {
        return repository.getFilteredArticles();
    }

    //Busca os Articles por combinacao de filtro
    public List<Article> findArticleAnyCategory(){
        //TODO
        return null;
    }

    //Busca em ordem alfabetica
    public List<Article> findAlphabetic(){
        List<Article> article = repository.getArticles();
        Collections.sort(article, Collator.getInstance());

        return article;
    }

    //Busca ao contrario da ordem alfabetica
    public List<Article> findAlphabeticReverse(){
        List<Article> article = repository.getArticles();
        Collections.sort(article, Collections.reverseOrder());

        return article;
    }

    //Busca o preço do maior para o menor
    public List<Article> findPrice(){
        List<Article> articlePrice = repository.getArticles();

        articlePrice.sort(Comparator.comparing(Article::getPrice));

        return articlePrice;
    }

    //Busca o preço do menor para o maior
    public List<Article> findPriceReverse(){
        List<Article> articlePrice = repository.getArticles();

        articlePrice.sort(Comparator.comparing(Article::getPrice).reversed());

        return articlePrice;
    }

}
