package com.mercadolibre.desafiospring.service;

import com.google.common.base.Strings;
import com.mercadolibre.desafiospring.dto.FilterSearchInputDTO;
import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.repository.ArticleRepository;
import com.mercadolibre.desafiospring.utils.FilterUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    FilterUtils filterUtils;

    public List<Article> getAllFiltersSearch(FilterSearchInputDTO filterSearchInputDTO) {
        List<Article> listResults = articleRepository.getArticles();

        List<Article> listFilterResults = listResults
                .stream()
                .filter(article -> filterUtils.filterByQueryParams(filterSearchInputDTO, article))
                .collect(Collectors.toList());
        return listFilterResults;
    }

}
