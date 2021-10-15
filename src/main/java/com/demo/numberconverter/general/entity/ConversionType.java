package com.demo.numberconverter.general.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ConversionType {

    DECIMAL_TO_STANDARD_ROMAN(0, "DecimalToStandardRoman"),
    BINARY_TO_STANDARD_ROMAN(1, "BinaryToStandardRoman");

    private int id;
    private String description;

    private ConversionType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @JsonValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
