package com.demo.numberconverter.converters.binarytostdroman.entity;

import com.demo.numberconverter.converters.binarytostdroman.service.BinaryValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { BinaryValidator.class })
public @interface ValidBinary {

    String message() default "The request has an invalid binary string";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
