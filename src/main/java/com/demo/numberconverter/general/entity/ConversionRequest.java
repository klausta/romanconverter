package com.demo.numberconverter.general.entity;

import com.demo.numberconverter.converters.binarytostdroman.entity.ValidBinary;
import com.demo.numberconverter.converters.binarytostdroman.entity.ValidBinaryToStdRomanRequest;
import com.demo.numberconverter.converters.decimaltostandardroman.entity.ValidDecimal;
import com.demo.numberconverter.converters.decimaltostandardroman.entity.ValidDecimalToStdRomanRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.sql.Timestamp;

public class ConversionRequest {

    private long id;
    private Timestamp requestDateTime;
    @JsonIgnore
    @ValidBinary(groups = ValidBinaryToStdRomanRequest.class)
    @ValidDecimal(groups = ValidDecimalToStdRomanRequest.class)
    private Object input;
    private Object output;
    private ConversionType conversionType;
    @JsonSerialize
    @JsonProperty("input")
    private JsonNode inputAsNode;

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

    public Object getInput() {
        return input;
    }

    public void setInput(Object input) {
        this.input = input;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }

    public ConversionType getConversionType() {
        return conversionType;
    }

    public void setConversionType(ConversionType conversionType) {
        this.conversionType = conversionType;
    }

    public JsonNode getInputAsNode() {
        return inputAsNode;
    }

    public void setInputAsNode(JsonNode inputAsNode) {
        this.inputAsNode = inputAsNode;
    }
}
