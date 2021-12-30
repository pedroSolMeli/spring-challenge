package com.mercadolibre.desafiospring.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.utils.FileUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class ArticleRepository {

    private static List<Article> articles = new ArrayList<>();
    private static final String PATH = "src/main/resources/articles.json";
    private static FileUtils fileUtils = new FileUtils();

    private static ObjectMapper objectMapper = new ObjectMapper();

    public Article createArticle(Article article) {
        try {
            articles.add(article);
            fileUtils.writeFile(PATH, articles);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return article;
    }

    public List<Article> getArticles() {
        try {
            String jsonString = FileUtils.GetFileToString(PATH);
            articles = Arrays.asList(objectMapper.readValue(jsonString, Article[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public Article getArticleById(Long productId){
        Article article = null;
        try {
            String jsonString = FileUtils.GetFileToString(PATH);
            articles = Arrays.asList(objectMapper.readValue(jsonString, Article[].class));
             article = articles.stream().filter(a -> a.getProductId() == productId).findFirst().orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return article;
    }

}

