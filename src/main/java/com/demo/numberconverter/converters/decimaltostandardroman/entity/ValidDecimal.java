package com.demo.numberconverter.converters.decimaltostandardroman.entity;

import com.demo.numberconverter.converters.decimaltostandardroman.service.DecimalValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { DecimalValidator.class })
public @interface ValidDecimal {

    String message() default "Only decimal values between 1 and 3999 can be converted to standard roman numerals";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
