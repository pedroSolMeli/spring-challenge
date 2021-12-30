package com.mercadolibre.desafiospring.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.utils.FileUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Article update(Long id, Article article) {
        try {
            if (!getArticleById(id).equals(null)){
                article.setProductId(id);
                int index = articles.indexOf(getArticleById(id));
                articles.set(index, article);
                fileUtils.writeFile(PATH, articles);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return article;
    }

    public void delete(Long id) {
        try {
            if (!getArticleById(id).equals(null)){
                List<Article> collect = articles.stream().filter(a -> !a.getProductId().equals(id)).collect(Collectors.toList());

                fileUtils.writeFile(PATH, collect);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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