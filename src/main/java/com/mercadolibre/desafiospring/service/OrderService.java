package com.mercadolibre.desafiospring.service;

import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.model.Order;
import com.mercadolibre.desafiospring.repository.OrderRepository;

import DTO.InputArticleDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
	@Autowired
	OrderRepository repository;
	@Autowired
	ArticleService articleService;

	public List<Order> findAll() {
		// vamos fazer um diferente para pegar por id? ou só não vamos mandar com pegar
		// 1?

		return repository.getOrders();
	}

	public Order createOrder(List<InputArticleDTO> listOrder) {
		List<Article> articleList = new ArrayList<Article>();
		for (InputArticleDTO inputArticleDTO : listOrder) {
			Article product = articleService.findArticleById(inputArticleDTO.getProductId());
			product.setQuantity(inputArticleDTO.getQuantity());
			articleList.add(product);
		}
		BigDecimal totalList = calculateTotal(articleList);
		Order order = Order.builder().products(articleList).total(totalList).build();
		return repository.createOrder(order);
	}



	private BigDecimal calculateTotal(List<Article> listOrder) {
		BigDecimal total = new BigDecimal("0.0");
		for (Article article : listOrder) {			
			total = total.add(article.getPrice().multiply(new BigDecimal(article.getQuantity())));
		}
		return total;
	}

	public void delete(Long id) {
//		repository.deleteOrder(id);
		
	}

	public Order update(Long id, Order order) {
//		Order orderToUpdate = repository.findById(id);
//		orderToUpdate = order;
		return null;
		
	}

	
}
