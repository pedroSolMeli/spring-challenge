package com.mercadolibre.desafiospring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
