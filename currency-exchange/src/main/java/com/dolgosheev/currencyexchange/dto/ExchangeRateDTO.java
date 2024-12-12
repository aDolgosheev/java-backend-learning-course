package com.dolgosheev.currencyexchange.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ExchangeRateDTO {
    private Long id;
    private CurrencyDTO baseCurrency;
    private CurrencyDTO targetCurrency;
    private BigDecimal rate;
}
