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
//            if (order != null){
//               return sortList(order, listResults);
//            }
            return listResults;
        }

        List<Article> listFilterResults = listResults
                .stream()
                .filter(article -> filterUtils.filterByQueryParams(articleFilterDTO, article))
                .collect(Collectors.toList());

//        if (order != null){
//            return sortList(order, listResults);
//        }

        return listFilterResults;

    }

    //Busca em ordem alfabetica
    public List<Article> findAlphabetic(List<Article> article){
        article.sort(Comparator.comparing(Article::getName));

        return article;
    }

    //Busca ao contrario da ordem alfabetica
    public List<Article> findAlphabeticReverse(List<Article> article){
        article.sort(Comparator.comparing(Article::getName).reversed());

        return article;
    }

    //Busca o preço do maior para o menor
    public List<Article> findPrice(List<Article> article){
        article.sort(Comparator.comparing(Article::getPrice));

        return article;
    }

    //Busca o preço do menor para o maior
    public List<Article> findPriceReverse(List<Article> article){
        article.sort(Comparator.comparing(Article::getPrice).reversed());

        return article;
    }

    //Busca por id
    public Article findArticleById(Long productId){
        Article article = repository.getArticleById(productId);

        return article;
    }

    public List<Article> sortList(Integer paramOrder, List<Article> article){

        List<Article> orderList;

        switch(paramOrder) {
            case 0:
                orderList = findAlphabetic(article);
                break;
            case 1:
                orderList = findAlphabeticReverse(article);
                break;
            case 2:
                orderList = findPrice(article);
                break;
            case 3:
                orderList = findPriceReverse(article);
                break;
            default:
                orderList = article;
        }

        return orderList;
    }

}
