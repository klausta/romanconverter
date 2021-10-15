package com.demo.numberconverter.converters.binarytostdroman.service;

import com.demo.numberconverter.converters.binarytostdroman.entity.ValidBinaryToStdRomanRequest;
import com.demo.numberconverter.general.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("binarytostdroman")
public class BinaryToStdRomanConverterService extends ConverterService {

    @Autowired
    @Qualifier("decimaltostdroman")
    ConverterService decimalToStdRomanConverterService;

    @Override
    public Object convert(Object input) {
        String binary = (String) input;
        if (binary == null || binary.trim().isEmpty()) {
            return EMPTY_RESULT;
        }
        return decimalToStdRomanConverterService.convert(Integer.parseInt(binary, 2));
    }

    @Override
    protected Class getValidationGroup() {
        return ValidBinaryToStdRomanRequest.class;
    }

    @Override
    protected Class getInputType() {
        return String.class;
    }

}
