package com.mercadolibre.desafiospring.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.logging.Filter;

@Component
public class FilterSearchInputMap extends HashMap<String, BiFunction<Object, Object, Boolean>> {

    public FilterSearchInputMap() {
        put("productId", FilterUtils::equalsInteger);
        put("name", FilterUtils::containsStringIgnoreCase);
        put("category", FilterUtils::containsStringIgnoreCase);
        put("brand", FilterUtils::containsStringIgnoreCase);
        put("price", FilterUtils::equalsBigDecimal);
        put("quantity", FilterUtils::equalsInteger);
        put("freeShipping", FilterUtils::equalsBoolean);
        put("prestige", FilterUtils::containsStringIgnoreCase);
    }

}