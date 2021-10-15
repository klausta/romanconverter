package com.demo.numberconverter.general.service;

import com.demo.numberconverter.general.entity.ConversionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConverterFactory {

    @Autowired
    @Qualifier("decimaltostdroman")
    private ConverterService decimalToStdRomanConverterService;

    @Autowired
    @Qualifier("binarytostdroman")
    private ConverterService binaryToStdRomanConverterService;

    public ConverterService getConverter(ConversionType conversionType) {
        if (conversionType.equals(ConversionType.DECIMAL_TO_STANDARD_ROMAN)) {
            return decimalToStdRomanConverterService;
        }

        if (conversionType.equals(ConversionType.BINARY_TO_STANDARD_ROMAN)) {
            return binaryToStdRomanConverterService;
        }

        return decimalToStdRomanConverterService;
    }

}
