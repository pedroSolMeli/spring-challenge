package com.mercadolibre.desafiospring.controller;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/" + "v1/" + "order")
public class OrderController {

    @GetMapping(value = "/{id}" ,produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> findAll(@PathVariable long id){

        return null;
    }

//    	@PostMapping(produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public  ResponseEntity<?> create(@RequestBody Order order) {
//
//		return null;
//	}
//
//	@PutMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
//	@ResponseBody
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//	public void update(@PathVariable Long id, @RequestBody Order order) {
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

}


