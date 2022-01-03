package com.mercadolibre.desafiospring.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.mercadolibre.desafiospring.model.Article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutputArticleDTO {
	 private long productId;
	    private String name;
	    private String category;
	    private String brand;
	    private BigDecimal price;
	 // quantidade para reqiuisição de compra, não estoque
	    private int quantityByOrder;
	    private boolean freeShipping;
	    private String prestige;

	   
}
