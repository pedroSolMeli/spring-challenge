package com.mercadolibre.desafiospring.service;

import com.mercadolibre.desafiospring.dto.ArticleFilterDTO;
import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.repository.ArticleRepository;
import com.mercadolibre.desafiospring.utils.FilterUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    FilterUtils filterUtils;

    public List<Article> getArticlesByFilters(ArticleFilterDTO articleFilterDTO) {
        List<Article> listResults = articleRepository.getArticles();

        if (articleFilterDTO.isNull()){
            return listResults;
        }

        List<Article> listFilterResults = listResults
                .stream()
                .filter(article -> filterUtils.filterByQueryParams(articleFilterDTO, article))
                .collect(Collectors.toList());
        return listFilterResults;
    }

}
