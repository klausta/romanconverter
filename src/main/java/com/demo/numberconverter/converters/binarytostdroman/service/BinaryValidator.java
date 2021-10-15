package com.demo.numberconverter.converters.binarytostdroman.service;

import com.demo.numberconverter.converters.binarytostdroman.entity.ValidBinary;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import liquibase.util.StringUtil;

public class BinaryValidator implements ConstraintValidator<ValidBinary, Object> {

    @Override
    public void initialize(ValidBinary constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object input, ConstraintValidatorContext context) {
        String value = (String) input;
        if (StringUtil.isEmpty(value)) {
            return true;
        }
        if (!value.matches("[0-1]+")) {
            return false;
        }
        return true;
    }
}
