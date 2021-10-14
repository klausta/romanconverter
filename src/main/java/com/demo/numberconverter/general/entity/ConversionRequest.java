package com.demo.numberconverter.general.entity;

import com.demo.numberconverter.converters.standardroman.entity.ValidStandardRomanRequest;
import java.sql.Timestamp;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ConversionRequest {

    private long id;
    private Timestamp requestDateTime;
    @Max(value = 3999, groups = ValidStandardRomanRequest.class)
    @Min(value = 1, groups = ValidStandardRomanRequest.class)
    private Integer decimalRequest;
    @ValidBinary
    private String binaryRequest;
    private String romanConvertedFromDecimal;
    private String romanConvertedFromBinary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(Timestamp requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getBinaryRequest() {
        return binaryRequest;
    }

    public void setBinaryRequest(String binaryRequest) {
        this.binaryRequest = binaryRequest;
    }

    public String getRomanConvertedFromBinary() {
        return romanConvertedFromBinary;
    }

    public void setRomanConvertedFromBinary(String romanConvertedFromBinary) {
        this.romanConvertedFromBinary = romanConvertedFromBinary;
    }

    public Integer getDecimalRequest() {
        return decimalRequest;
    }

    public void setDecimalRequest(Integer decimalRequest) {
        this.decimalRequest = decimalRequest;
    }

    public String getRomanConvertedFromDecimal() {
        return romanConvertedFromDecimal;
    }

    public void setRomanConvertedFromDecimal(String romanConvertedFromDecimal) {
        this.romanConvertedFromDecimal = romanConvertedFromDecimal;
    }
}
