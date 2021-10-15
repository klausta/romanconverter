package com.demo.numberconverter.general.service;

import com.demo.numberconverter.general.entity.ConversionRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * To implement a new converter extend the abstract class ConverterService.
 * As minimum requirement the getOutputTyp() and Convert() methods must be implemented.
 * Optional bean validation specific to the converter can be added by defining a ValidationGroup and
 * implementing the getValidationGroup() method below.
 * After adding the new converter extend the classes ConversionType and ConverterFactory accordingly.
 */

public abstract class ConverterService {

    protected static final String EMPTY_RESULT = "";

    @Autowired
    Validator validator;
    @Autowired
    ObjectMapper objectMapper;

    public ConversionRequest process(ConversionRequest conversionRequest) throws JsonProcessingException {
        deserializeInputParameter(conversionRequest);
        validateRequest(conversionRequest);
        conversionRequest.setOutput(convert(conversionRequest.getInput()));
        return conversionRequest;
    };

    protected void validateRequest(ConversionRequest conversionRequest) {
        if (getValidationGroup() == null) {
            return;
        }

        Set<ConstraintViolation<ConversionRequest>> violations =
                validator.validate(conversionRequest, getValidationGroup());

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<ConversionRequest> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }
    }

    protected abstract Class getValidationGroup();

    protected void deserializeInputParameter(ConversionRequest conversionRequest) throws JsonProcessingException {
        conversionRequest
                .setInput(objectMapper.readValue(conversionRequest.getInputAsNode().toString(), getInputType()));
    }

    protected abstract Class getInputType();

    public abstract Object convert(Object object);
}
