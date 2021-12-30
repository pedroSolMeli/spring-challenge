package com.mercadolibre.desafiospring.controller;

import java.util.List;

import com.mercadolibre.desafiospring.dto.ArticleFilterDTO;
import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/" + "v1/" + "articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

//    @GetMapping(produces = APPLICATION_JSON_VALUE)
//    @ResponseBody
//    @ResponseStatus(code = HttpStatus.OK)
//    public ResponseEntity<?> findAll(@RequestParam(required = false) Long productId,
//                                     @RequestParam(required = false) String name, @RequestParam(required = false) String category,
//                                     @RequestParam(required = false) String brand, @RequestParam(required = false) BigDecimal price,
//                                     @RequestParam(required = false) int quantity, @RequestParam(required = false) Boolean freeShipping,
//                                     @RequestParam(required = false) String prestige) {
//        return null;
//    }

    @GetMapping()
    public ResponseEntity<?> findAll(ArticleFilterDTO articleFilterDTO) {
        List<Article> articles = articleService.getArticlesByFilters(articleFilterDTO);
        return ResponseEntity.ok(articles);
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

