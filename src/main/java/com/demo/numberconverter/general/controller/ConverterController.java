package com.demo.numberconverter.general.controller;

import com.demo.numberconverter.general.entity.ConversionRequestDto;
import com.demo.numberconverter.general.service.ConversionTypeProvider;
import com.demo.numberconverter.general.service.ConverterFactory;
import com.demo.numberconverter.general.service.ConverterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numberconverter")
public class ConverterController {

    @Autowired
    ConverterFactory converterFactory;
    @Autowired
    ConversionTypeProvider conversionTypeProvider;

    @PostMapping("/convert")
    public ConversionRequestDto convertToRomanNumeral(@RequestBody @Valid ConversionRequestDto conversionRequestDto)
            throws JsonProcessingException {
        ConverterService converterService = converterFactory.getConverter(conversionRequestDto.getConversionType());
        return converterService.process(conversionRequestDto);
    }

    @GetMapping("/getConversionTypes")
    public Map<Integer, String> getConversionTypes() {
        return conversionTypeProvider.getConversionTypes();
    }

}
