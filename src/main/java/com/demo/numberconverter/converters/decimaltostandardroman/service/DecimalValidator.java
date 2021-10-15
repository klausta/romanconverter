package com.demo.numberconverter.converters.decimaltostandardroman.service;

import com.demo.numberconverter.converters.decimaltostandardroman.entity.ValidDecimal;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DecimalValidator implements ConstraintValidator<ValidDecimal, Object> {

    @Override
    public void initialize(ValidDecimal constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object input, ConstraintValidatorContext context) {
        int value = (int) input;
        return value > 0 && value < 4000;
    }
}
