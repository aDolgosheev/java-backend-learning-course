package com.dolgosheev.currencyexchange.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeRequestDTO {
    private String from;
    private String to;
    private BigDecimal amount;
}
