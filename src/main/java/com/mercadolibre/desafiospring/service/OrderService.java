package com.mercadolibre.desafiospring.service;

import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.model.Order;
import com.mercadolibre.desafiospring.repository.OrderRepository;

import DTO.InputArticleDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
	@Autowired
	OrderRepository repository;


	public List<Order> findAll() {
		// vamos fazer um diferente para pegar por id? ou só não vamos mandar com pegar
		// 1?

		return repository.getOrders();
	}

	public BigDecimal createOrder(List<InputArticleDTO> listOrder) {
		BigDecimal totalList = calculateTotal(listOrder);
		Order order = Order.builder().products(InputArticleDTO.converteList(listOrder)).total(totalList).build();
		repository.createOrder(order);
		return totalList;
	}

	private BigDecimal calculateTotal(List<InputArticleDTO> listOrder) {
		BigDecimal total = new BigDecimal("0.0");
		for (InputArticleDTO article : listOrder) {			
//			para um retorno de objeto pegar o preço:
//			BigDecimal priceArticle = serviceArticle.findArticleById(article.getProductId()).getPrice();
//			total = total.add(priceArticle.multiply(new BigDecimal(article.getQuantity())));
									
//			total = total.add(article.getPrice().multiply(new BigDecimal(article.getQuantity())));
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
