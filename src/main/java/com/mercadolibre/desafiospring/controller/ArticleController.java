package com.mercadolibre.desafiospring.controller;

import java.util.LinkedHashSet;
import java.util.List;

import com.mercadolibre.desafiospring.dto.ArticleFilterDTO;
import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/" + "v1/" + "articles")
public class ArticleController {

    @Autowired
    ArticleService service;

    @GetMapping()
    public ResponseEntity<?> findAll(ArticleFilterDTO articleFilterDTO,  @RequestParam(required = false) Integer order){
		LinkedHashSet<Article> articles = service.findArticlesByFilters(articleFilterDTO, order);
        return ResponseEntity.ok(articles);
    }

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public  ResponseEntity<?> create(@RequestBody Article article) {

		return null;
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody Article article) {
		service.updateArticle(id, article);
	}


	@DeleteMapping(value = "/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.deleteArticle(id);
		return new ResponseEntity<>("Deleted article id: " + id, HttpStatus.NO_CONTENT);
	}

}

