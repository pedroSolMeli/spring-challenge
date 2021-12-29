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

    private long defaultProductIdValue = 0;
    private String defaultNameValue = "";


    public Article createArticle(Article article) {
        try {
            articles.add(article);
            fileUtils.writeFile(PATH, articles);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return article;
    }

    public static List<Article> getArticles() {
        try {
            String jsonString = FileUtils.GetJsonBodyMock(PATH);
            articles = Arrays.asList(objectMapper.readValue(jsonString, Article[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public static List<Article> getFilteredArticles() {
        articles = getArticles();
        List<Article> filteredArticles = articles;
        return filteredArticles;
    }

}

