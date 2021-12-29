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

        List<Article> filters = articleRepository.getArticles();

        List<Article> listResults = listParseFilterResults(filters);

        List<Article> listFilterResults = listResults
                .stream()
                .filter(filterOutputDTO -> filterUtils.filterByQueryParams(filterSearchInputDTO, filterOutputDTO))
                .collect(Collectors.toList());
        return listFilterResults;
    }

    private List<Article> listParseFilterResults(List<Article> filters) {
        List<Article> listResults = new ArrayList<>();
        for (Object filter : filters) {
            try {
                Map<String, Object> caseFilterAsMap = (Map<String, Object>) filter;
                Article article = Article.builder()
                        .productId((Long) caseFilterAsMap.get("productId"))
                        .name((String) caseFilterAsMap.get("name"))
                        .category((String) caseFilterAsMap.get("category"))
                        .brand((String) caseFilterAsMap.get("brand"))
                        .price((BigDecimal) caseFilterAsMap.get("price"))
                        .productId((Integer) caseFilterAsMap.get("quantity"))
                        .freeShipping((Boolean) caseFilterAsMap.get("freeShipping"))
                        .build();
                listResults.add(article);
            } catch (ClassCastException e) {
                log.warn(String.format("Error on getAllFilters parse: %s", filter.toString()), e);
            }
        }
        return listResults;
    }

}
