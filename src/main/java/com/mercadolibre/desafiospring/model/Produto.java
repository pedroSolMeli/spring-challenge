package com.mercadolibre.desafiospring.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Produto {

    private long productId;
    String name;
    String category;
    String brand;
    BigDecimal price;
    int quantity;
    boolean freeShipping;
    String prestige;

}
