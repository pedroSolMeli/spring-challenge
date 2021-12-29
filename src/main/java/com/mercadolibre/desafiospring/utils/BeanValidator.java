package com.mercadolibre.desafiospring.utils;

import com.google.common.base.CaseFormat;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BeanValidator {

    public static <T> void validate(T obj) throws Exception {
        validate(obj, Default.class);
    }

    public static <T> void validate(T obj, Class<?>... groups) throws Exception {
        if (obj == null)
            throw new NullPointerException("Bean object is null");

        ValidatorFactory validator = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> errors = validator.getValidator().validate(obj, groups);

        if (errors.size() > 0) {
            StringBuilder message = new StringBuilder("Parameter" + (errors.size() == 1 ? " " : "s "));

            String propertiesNames = errors.stream()
                    .map(error -> {
                        boolean isNotCustomValidationMessage = error.getMessageTemplate().contains("javax.validation");
                        if (isNotCustomValidationMessage)
                            return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_CAMEL, error.getPropertyPath().toString() + " " + error.getMessage());
                        return error.getMessage();
                    })
                    .sorted()
                    .collect(Collectors.joining(", "));

            message.append(propertiesNames);

            throw new Exception(message.toString());
        }
    }

}
