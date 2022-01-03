package com.mercadolibre.desafiospring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleFilterDTO {

    private Long productId;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private Integer quantity;
    private Boolean freeShipping;
    private String prestige;

    public boolean isNull(){
        boolean isNull = productId == null  && name == null && category == null
                && brand == null && price == null && quantity == null
                && freeShipping == null && prestige == null;

        return isNull;
    }

    public boolean productIdIsNull(){
        boolean isNull = productId == null;
        return isNull;
    }

    public boolean nameIsNull(){
        boolean isNull = name == null;
        return isNull;
    }

    public boolean categoryIsNull(){
        boolean isNull = category == null;
        return isNull;
    }

    public boolean brandIsNull(){
        boolean isNull = brand == null;
        return isNull;
    }

    public boolean priceIsNull(){
        boolean isNull = price == null;
        return isNull;
    }

    public boolean quantityNull(){
        boolean isNull = quantity == null;
        return isNull;
    }

    public boolean freeShippingIsNull(){
        boolean isNull = freeShipping == null;
        return isNull;
    }

    public boolean prestigeIsNull(){
        boolean isNull = prestige == null;
        return isNull;
    }

}
