package com.mercadolibre.desafiospring.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class Pedido {

    List<Produto> produtos;
    BigDecimal total;

}
