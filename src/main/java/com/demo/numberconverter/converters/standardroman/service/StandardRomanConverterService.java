package com.demo.numberconverter.converters.standardroman.service;

import com.demo.numberconverter.converters.standardroman.entity.ValidStandardRomanRequest;
import com.demo.numberconverter.general.service.ConverterService;
import com.demo.numberconverter.general.entity.ConversionRequest;
import java.util.Set;
import java.util.TreeMap;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import liquibase.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("standardconverter")
public class StandardRomanConverterService implements ConverterService {

    @Autowired
    Validator validator;

    private static final String EMPTY_RESULT = "";

    @Override
    public ConversionRequest addRomanNumerals(ConversionRequest conversionRequest) {
        validateRequest(conversionRequest);
        conversionRequest.setRomanConvertedFromBinary(fromBinarytoRoman(conversionRequest.getBinaryRequest()));
        conversionRequest.setRomanConvertedFromDecimal(fromDecimaltoRoman(conversionRequest.getDecimalRequest()));
        return conversionRequest;
    }

    private String fromBinarytoRoman(String binary) {
        if (StringUtil.isEmpty(binary)) {
            return EMPTY_RESULT;
        }
        return fromDecimaltoRoman(Integer.parseInt(binary, 2));
    }

    private String fromDecimaltoRoman(Integer decimal) {
        if (decimal == null) {
            return EMPTY_RESULT;
        }

        int l = map.floorKey(decimal);
        if (decimal == l) {
            return map.get(decimal);
        }
        return map.get(l) + fromDecimaltoRoman(decimal - l);
    }

    private void validateRequest(ConversionRequest conversionRequest) {
        Set<ConstraintViolation<ConversionRequest>> violations =
                validator.validate(conversionRequest, ValidStandardRomanRequest.class);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<ConversionRequest> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }
    }

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }
}
