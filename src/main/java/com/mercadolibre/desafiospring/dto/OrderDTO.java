package com.mercadolibre.desafiospring.dto;

import java.math.BigDecimal;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
		private Long id;
		private List<OutputArticleDTO> products;
	    private BigDecimal total;
}
