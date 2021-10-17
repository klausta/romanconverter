package com.demo.numberconverter.general.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TBCONVERSIONREQUEST")
public class ConversionRequestDao implements BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp requestDateTime = Timestamp.valueOf(LocalDateTime.now());
    private String input;
    private String output;
    private ConversionType conversionType;

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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public ConversionType getConversionType() {
        return conversionType;
    }

    public void setConversionType(ConversionType conversionType) {
        this.conversionType = conversionType;
    }
}
