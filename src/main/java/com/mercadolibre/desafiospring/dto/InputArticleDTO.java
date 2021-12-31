package com.mercadolibre.desafiospring.dto;

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
public class InputArticleDTO {
	private long productId;
	private String name;
	private String brand;
	// quantidade para reqiuisição de compra, não estoque
	private int quantity;

	public static Article converte(InputArticleDTO dto) {
		Article article = Article.builder().brand(dto.getBrand()).name(dto.getBrand()).productId(dto.getProductId())
				.build();
		return article;
	}

	public static List<Article> converteList(List<InputArticleDTO> articles) {
		return articles.stream().map(u -> converte(u)).collect(Collectors.toList());
	}

}
