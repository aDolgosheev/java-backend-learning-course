package com.dolgosheev.currencyexchange.controller;

import com.dolgosheev.currencyexchange.dto.ExchangeRateDTO;
import com.dolgosheev.currencyexchange.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @GetMapping("/exchangeRates")
    public List<ExchangeRateDTO> getAllExchangeRates() {
        return exchangeRateService.getAllExchangeRates();
    }

    @GetMapping("/exchangeRate/{codes}")
    public ExchangeRateDTO getExchangeRate(@PathVariable String codes) {
        String baseCode = codes.substring(0, 3);
        String targetCode = codes.substring(3);
        return exchangeRateService.getExchangeRate(baseCode, targetCode);
    }

    @PostMapping("/exchangeRates")
    public ResponseEntity<ExchangeRateDTO> createExchangeRate(
            @RequestParam String baseCurrencyCode,
            @RequestParam String targetCurrencyCode,
            @RequestParam BigDecimal rate) {
        return new ResponseEntity<>(
                exchangeRateService.createExchangeRate(baseCurrencyCode, targetCurrencyCode, rate),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/exchangeRate/{codes}")
    public ExchangeRateDTO updateExchangeRate(
            @PathVariable String codes,
            @RequestParam BigDecimal rate) {
        String baseCode = codes.substring(0, 3);
        String targetCode = codes.substring(3);
        return exchangeRateService.updateExchangeRate(baseCode, targetCode, rate);
    }

    @GetMapping("/exchange")
    public Map<String, Object> calculateExchange(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam BigDecimal amount) {
        BigDecimal convertedAmount = exchangeRateService.calculateExchange(from, to, amount);
        ExchangeRateDTO rate = exchangeRateService.getExchangeRate(from, to);

        return Map.of(
                "baseCurrency", rate.getBaseCurrency(),
                "targetCurrency", rate.getTargetCurrency(),
                "rate", rate.getRate(),
                "amount", amount,
                "convertedAmount", convertedAmount
        );
    }
}