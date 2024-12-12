package com.dolgosheev.currencyexchange.dto;

import lombok.Data;

@Data
public class CurrencyDTO {
    private Long id;
    private String code;
    private String name;
    private String sign;
}
