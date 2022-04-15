package com.example.bookservice.response;

import java.math.BigDecimal;

public class Cambio {

    private Long id;

    private String from;

    private String to;

    private BigDecimal convertionFactor;

    private BigDecimal convertedValue;

    private String environment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConvertionFactor() {
        return convertionFactor;
    }

    public void setConvertionFactor(BigDecimal convertionFactor) {
        this.convertionFactor = convertionFactor;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
