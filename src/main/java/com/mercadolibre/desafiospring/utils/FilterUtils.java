package com.mercadolibre.desafiospring.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class FilterUtils {

    @Autowired
    FilterInputMap filterInputMap;

    public static boolean containsStringIgnoreCase(Object argBase, Object argCompare) {
        String baseValue = (String) argBase;
        String compareValue = (String) argCompare;

        return (Objects.nonNull(baseValue) && Objects.nonNull(compareValue))
                && compareValue.toLowerCase().contains(baseValue.toLowerCase());
    }

    public static boolean equalsLong(Object argBase, Object argCompare) {
        Long baseValue = (Long) argBase;
        Long compareValue = (Long) argCompare;

        return baseValue.equals(compareValue);
    }

    public static boolean equalsInteger(Object argBase, Object argCompare) {
        Integer baseValue = (Integer) argBase;
        Integer compareValue = (Integer) argCompare;

        return baseValue.equals(compareValue);
    }

    public static boolean equalsBigDecimal(Object argBase, Object arCompare) {
        BigDecimal baseValue = (BigDecimal) argBase;
        BigDecimal compareValue = (BigDecimal) arCompare;

        return baseValue.equals(compareValue);
    }

    public static boolean equalsBoolean(Object argBase, Object argCompare) {
        Boolean baseValue = (Boolean) argBase;
        Boolean compareValue = (Boolean) argCompare;

        return baseValue == compareValue;
    }

    public boolean filterByQueryParams(Object inputQueryParams, Object baseObjValues) {
        Map<String, Object> queryParamsAsMap = convertObjectToMap(inputQueryParams);
        Map<String, Object> baseObjValuesAsMap = convertObjectToMap(baseObjValues);

        return queryParamsAsMap.entrySet()
                .stream()
                .filter(entry -> Objects.nonNull(entry.getValue()))
                .anyMatch(entry -> filterInputMap.get(entry.getKey())
                        .apply(entry.getValue(), baseObjValuesAsMap.get(entry.getKey())));
    }

    public Map<String, Object> convertObjectToMap(Object object) {
        ObjectMapper mapObject = new ObjectMapper();
        Map<String, Object> mapObj = mapObject.convertValue(object, Map.class);
        return mapObj;
    }
}
