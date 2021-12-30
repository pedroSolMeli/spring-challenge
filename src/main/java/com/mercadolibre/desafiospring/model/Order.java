package com.mercadolibre.desafiospring.model;


import lombok.Data;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Data
public class Order {	
	
	private Long id;
	private List<Article> products;
    private BigDecimal total;

    
    
    public Order(List<Article> products, BigDecimal total) {
    	this.id = geraId();
    	this.products = products;
    	this.total = total;
    }
    
    
    private long geraId() {
    	Random rand = new Random();
        return rand.nextLong();
    }






}
