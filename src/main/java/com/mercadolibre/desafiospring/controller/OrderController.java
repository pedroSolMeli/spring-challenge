package com.mercadolibre.desafiospring.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.mercadolibre.desafiospring.model.Article;
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
public class OrderController {

	@Autowired
	OrderService service;
//
//	@GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	@ResponseStatus(code = HttpStatus.OK)
//	public ResponseEntity<?> find(@PathVariable long id) {
//		service.findAll();
//		return null;
//	}
//
//	@PostMapping(produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public ResponseEntity<?> create(@RequestBody List<Article> listOrder) {
//		BigDecimal total = service.createOrder(listOrder);
//		return ResponseEntity.ok(total);
//	}
//
//
//	@PutMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//	public void update(@PathVariable Long id, @RequestBody Order order) {
//		service.update(id, order);
//	}
//
//
//	@DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable Long id) {
//		service.delete(id);
//	}

}
