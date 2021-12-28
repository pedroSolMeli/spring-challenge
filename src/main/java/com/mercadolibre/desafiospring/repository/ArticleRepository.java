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

    public static Article createProduto(Article article) throws IOException {
        articles.add(article);
        fileUtils.writeFile(PATH, articles);
        return article;
    }

    public static List<Article> getProdutos() throws IOException {
        String jsonString = FileUtils.GetJsonBodyMock(PATH);
        articles = Arrays.asList(objectMapper.readValue(jsonString, Article[].class));
        return articles;
    }

}
