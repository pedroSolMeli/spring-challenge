package com.mercadolibre.desafiospring.service;

import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.model.Order;
import com.mercadolibre.desafiospring.repository.OrderRepository;
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

	public BigDecimal createOrder(List<Article> listOrder) {
		BigDecimal totalList = calculateTotal(listOrder);
		Order order = Order.builder().products(listOrder).total(totalList).build();
		repository.createOrder(order);
		return totalList;
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
