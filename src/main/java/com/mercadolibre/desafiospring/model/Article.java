package com.mercadolibre.desafiospring.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
@JsonInclude()
public class Article {

    @JsonProperty("productId")
    private Long productId;
    @JsonProperty("name")
    String name;
    String category;
    String brand;
    BigDecimal price;
    Integer quantity;
    @JsonProperty("freeShipping")
    Boolean freeShipping;
    String prestige;

}
