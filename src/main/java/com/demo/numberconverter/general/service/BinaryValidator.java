package com.demo.numberconverter.general.service;

import com.demo.numberconverter.general.entity.ValidBinary;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import liquibase.util.StringUtil;

public class BinaryValidator implements ConstraintValidator<ValidBinary, String> {

    @Override
    public void initialize(ValidBinary constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtil.isEmpty(value)) {
            return true;
        }
        if (!value.matches("[0-1]+")) {
            return false;
        }
        return true;
    }
}
