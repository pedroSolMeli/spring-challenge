package com.mercadolibre.desafiospring.service;

import com.mercadolibre.desafiospring.dto.ArticleFilterDTO;
import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.repository.ArticleRepository;
import com.mercadolibre.desafiospring.utils.FilterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    @Autowired
    FilterUtils filterUtils;

    //Cria um article
    public Article createArticle(Article article){
        return repository.createArticle(article);
    }

    //Atualizar um article
    public Article updateArticle(Long id, Article article){
        return repository.update(id, article);
    }

    //Atualizar um article
    public void deleteArticle(Long id){
        repository.delete(id);
    }

    //Busca todos Articles em uma lista
    public List<Article> findAll() {
        return repository.getArticles();
    }

    //Busca os Articles por filtros
    public List<Article> findArticlesByFilters(ArticleFilterDTO articleFilterDTO) {
        List<Article> listResults = repository.getArticles();

        if (articleFilterDTO.isNull()){
            return listResults;
        }

        List<Article> listFilterResults = listResults
                .stream()
                .filter(article -> filterUtils.filterByQueryParams(articleFilterDTO, article))
                .collect(Collectors.toList());
        return listFilterResults;
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

    //Busca em ordem alfabetica
    public Article findArticleById(Long productId){
        Article article = repository.getArticleById(productId);

        return article;
    }

}
