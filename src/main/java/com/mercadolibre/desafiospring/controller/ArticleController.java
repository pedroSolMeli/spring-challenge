package com.mercadolibre.desafiospring.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.math.BigDecimal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/" + "v1/" + "articles")
public class ArticleController {

	@GetMapping(produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> findAll(@RequestParam(required = false) Long productId,
			@RequestParam(required = false) String name, @RequestParam(required = false) String category,
			@RequestParam(required = false) String brand, @RequestParam(required = false) BigDecimal price,
			@RequestParam(required = false) int quantity, @RequestParam(required = false) Boolean freeShipping,
			@RequestParam(required = false) String prestige) {
				return null;
	}
	
//	@PostMapping(produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public  ResponseEntity<?> create(@RequestBody Article article) {
//		
//		return null;
//	}
//
//	@PutMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//	public void update(@PathVariable Long id, @RequestBody Article article) {
//		service.update(id, article);
//	}
//
//	
//	@DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable Long id) {
//		service.delete(id);
//	}
//	
	

}

