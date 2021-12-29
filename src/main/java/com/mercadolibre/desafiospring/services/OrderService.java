package com.mercadolibre.desafiospring.services;

import com.mercadolibre.desafiospring.model.Article;
import com.mercadolibre.desafiospring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {


    public void findAll() {
    }

    public void createOrder(List<Article> listOrder) {
        BigDecimal totalList = calculateTotal(listOrder);
        //Order order = new Order(listOrder, totalList )  ;

    }

    private BigDecimal calculateTotal(List<Article> listOrder) {
        BigDecimal total = new BigDecimal("0.0");
        for (Article article: listOrder ) {
             total =total.add(article.getPrice().multiply(new BigDecimal(article.getQuantity())));
        }
        return  total;
    }
}
