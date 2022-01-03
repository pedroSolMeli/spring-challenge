package com.mercadolibre.desafiospring.service;

import com.mercadolibre.desafiospring.dto.ArticleFilterDTO;
import com.mercadolibre.desafiospring.exceptions.ApiError;
import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

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
    public LinkedHashSet<Article> findArticlesByFilters(ArticleFilterDTO articleFilterDTO, Integer order) throws ApiError {
        List<Article> listArticles = repository.getArticles();

        LinkedHashSet<Article> linkedArticle;

        if (articleFilterDTO.isNull()){

            linkedArticle = order != null ? new LinkedHashSet<>(sortList(order, listArticles)) : new LinkedHashSet<>(listArticles);

            return  linkedArticle;
        }

        List<Article> collectArticle = listArticles.stream()
                .filter(article -> articleFilterDTO.productIdIsNull() || article.getProductId().equals(articleFilterDTO.getProductId()))
                .filter(article -> articleFilterDTO.nameIsNull() || article.getName().equals(articleFilterDTO.getName()))
                .filter(article -> articleFilterDTO.categoryIsNull() || article.getCategory().equals(articleFilterDTO.getCategory()))
                .filter(article -> articleFilterDTO.brandIsNull() || article.getBrand().equals(articleFilterDTO.getBrand()))
                .filter(article -> articleFilterDTO.priceIsNull() || article.getPrice().equals(articleFilterDTO.getPrice()))
                .filter(article -> articleFilterDTO.quantityNull() || article.getQuantity().equals(articleFilterDTO.getQuantity()))
                .filter(article -> articleFilterDTO.freeShippingIsNull() || article.getFreeShipping().equals(articleFilterDTO.getFreeShipping()))
                .filter(article -> articleFilterDTO.prestigeIsNull() || article.getPrestige().equals(articleFilterDTO.getPrestige())).collect(Collectors.toList());

       if (collectArticle.size() == 0){
           throw new ApiError("Nenhum artigo encontrado com o filtro informado", HttpStatus.NOT_FOUND.value());
       }
        linkedArticle = order != null ? new LinkedHashSet<>(sortList(order, collectArticle)) : new LinkedHashSet<>(collectArticle);

        return linkedArticle;
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
