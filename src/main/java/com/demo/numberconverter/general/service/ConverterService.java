package com.demo.numberconverter.general.service;

import com.demo.numberconverter.general.entity.ConversionRequestDao;
import com.demo.numberconverter.general.entity.ConversionRequestDto;
import com.demo.numberconverter.general.mapper.ConversionRequestEntityMapper;
import com.demo.numberconverter.general.repository.ConversionRequestRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    ConversionRequestRepository repository;
    @Autowired
    ConversionRequestEntityMapper mapper;

    @Transactional
    public ConversionRequestDto process(ConversionRequestDto conversionRequestDto) throws JsonProcessingException {
        deserializeInputParameter(conversionRequestDto);
        validateRequest(conversionRequestDto);
        conversionRequestDto.setOutput(convert(conversionRequestDto.getInput()));
        return persistRequest(conversionRequestDto);
    };

    protected void validateRequest(ConversionRequestDto conversionRequestDto) {
        if (getValidationGroup() == null) {
            return;
        }

        Set<ConstraintViolation<ConversionRequestDto>> violations =
                validator.validate(conversionRequestDto, getValidationGroup());

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<ConversionRequestDto> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }
    }

    protected abstract Class getValidationGroup();

    protected void deserializeInputParameter(ConversionRequestDto conversionRequestDto) throws JsonProcessingException {
        conversionRequestDto
                .setInput(objectMapper.readValue(conversionRequestDto.getInputAsNode().toString(), getInputType()));
    }

    protected abstract Class getInputType();

    public abstract Object convert(Object object);

    protected ConversionRequestDto persistRequest(ConversionRequestDto conversionRequestDto)  {
        return mapper.mapToDto(repository.save(mapper.mapToDao(conversionRequestDto)));
    }
}
