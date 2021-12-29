package com.mercadolibre.desafiospring.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonFilter("articleFilter")
public class Article {

    private long productId;
    String name;
    String category;
    String brand;
    BigDecimal price;
    int quantity;
    boolean freeShipping;
    String prestige;

}
