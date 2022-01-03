package com.mercadolibre.desafiospring.service;

import com.mercadolibre.desafiospring.dto.InputArticleToShopDTO;
import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.model.Order;
import com.mercadolibre.desafiospring.repository.OrderRepository;

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
		return repository.getOrders();
	}

	public Order createOrder(List<InputArticleToShopDTO> listOrder) {
		List<Article> articleList = new ArrayList<Article>();
		for (InputArticleToShopDTO inputArticleDTO : listOrder) {
			Article product = articleService.findArticleById(inputArticleDTO.getProductId());
			product.setQuantity(inputArticleDTO.getQuantity());
			articleList.add(product);
		}
		BigDecimal totalList = calculateTotal(articleList);
		Order order = new Order(articleList, totalList);
		return repository.createOrder(order);
	}



	private BigDecimal calculateTotal(List<Article> listOrder) {
		BigDecimal total = new BigDecimal("0.0");
		for (Article article : listOrder) {			
			total = total.add(article.getPrice().multiply(new BigDecimal(article.getQuantity())));
		}
		return total;
	}

//	public void delete(Long id) {
////		repository.deleteOrder(id);
//		
//	}
//
//	public Order update(Long id, Order order) {
////		Order orderToUpdate = repository.findById(id);
////		orderToUpdate = order;
//		return null;
//		
//	}

	
}
