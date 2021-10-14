package com.demo.numberconverter.general.controller;

import com.demo.numberconverter.general.entity.ConversionRequest;
import com.demo.numberconverter.general.service.ConverterService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numberconverter")
public class ConverterController {

    public static final String CONVERTER = "standardconverter";

    @Autowired
    @Qualifier(CONVERTER)
    ConverterService converterService;

    @PostMapping("/toRoman")
    public ConversionRequest convertToRomanNumeral(@RequestBody @Valid ConversionRequest conversionRequest) {
        return converterService.addRomanNumerals(conversionRequest);
    }
}
