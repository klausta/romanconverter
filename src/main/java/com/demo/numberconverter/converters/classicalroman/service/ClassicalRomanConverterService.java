package com.demo.numberconverter.converters.classicalroman.service;

import com.demo.numberconverter.general.service.ConverterService;
import com.demo.numberconverter.general.entity.ConversionRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * This is a demo as to how an alterantive converter service can be added.
 * To add an alternative converter implement the ConverterService as below.
 * Assign a qualifier e.g. "classicalromanconverter" and specify in the
 * ConverterController which converter to apply.
 * Any required validation specific to the ConverterService implementation can be
 * added analogue to how its done in the StandardRomanConverterService.
 */

@Service
@Qualifier("classicalromanconverter")
public class ClassicalRomanConverterService implements ConverterService {

    @Override
    public ConversionRequest addRomanNumerals(ConversionRequest conversionRequest) {
        // to implement
        return conversionRequest;
    }
}
