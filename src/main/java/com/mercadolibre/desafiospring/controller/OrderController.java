package com.mercadolibre.desafiospring.controller;

import com.mercadolibre.desafiospring.dto.InputArticleToShopDTO;
import com.mercadolibre.desafiospring.model.Order;
import com.mercadolibre.desafiospring.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/" + "v1/" + "order")
//POST: /api/v1/purchase-request
public class OrderController {

	@Autowired
	OrderService service;

	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> find() {
		List<Order> listOrders = service.findAll();
		return ResponseEntity.ok(listOrders);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody List<InputArticleToShopDTO> listOrder) {
		Order order = service.createOrder(listOrder);
		return ResponseEntity.ok(order);
	}


//	@PutMapping(value = "/{id}")
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//	public void update(@PathVariable Long id, @RequestBody Order order) {
//		service.update(id, order);
//	}
//
//
//	@DeleteMapping(value = "/{id}")
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable Long id) {
//		service.delete(id);
//	}

}
