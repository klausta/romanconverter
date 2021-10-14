package com.demo.numberconverter.converters.standardroman.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import com.demo.numberconverter.general.entity.ConversionRequest;
import javax.xml.validation.Validator;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StandardRomanConverterServiceTest {

    @InjectMocks
    StandardRomanConverterService testSubject;
    @Mock
    Validator validator;

    private ConversionRequest conversionRequest;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        conversionRequest = new ConversionRequest();
    }

    @Test(dataProvider = "test_data_sets_for_conversion_to_roman_numerals")
    public void binary_and_decimals_are_converted_correct_to_roman_numerals(Integer decimalRequest,
            String binaryRequest, String expectedRomanResponseToDecimal, String expectedRomanResponseToBinary) {
        // arrange
        conversionRequest.setDecimalRequest(decimalRequest);
        conversionRequest.setBinaryRequest(binaryRequest);

        // act
        testSubject.addRomanNumerals(conversionRequest);

        // assert
        assertThat(conversionRequest.getRomanConvertedFromBinary()).isEqualTo(expectedRomanResponseToBinary);
        assertThat(conversionRequest.getRomanConvertedFromDecimal()).isEqualTo(expectedRomanResponseToDecimal);
    }

    @DataProvider(name = "test_data_sets_for_conversion_to_roman_numerals")
    public static Object[][] romandatasets() {
        return new Object[][] { { 5, "101", "V", "V" }, { null, null, "", "" }, { 190, "1011", "CXC", "XII" },
                { 5, "101", "V", "V" }, { 5, "101", "V", "V" }, { 5, "101", "V", "V" }, { 5, "101", "V", "V" },
                { 5, "101", "V", "V" }, { 5, "101", "V", "V" }, { 5, "101", "V", "V" } };
    }

}
