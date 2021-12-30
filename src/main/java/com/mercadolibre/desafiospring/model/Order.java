package com.mercadolibre.desafiospring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import DTO.InputArticleDTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	private Long id;
	private List<Article> products;
    private BigDecimal total;

}
