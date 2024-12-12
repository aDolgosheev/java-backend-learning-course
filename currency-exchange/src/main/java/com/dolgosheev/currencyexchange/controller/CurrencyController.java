package com.dolgosheev.currencyexchange.controller;

import com.dolgosheev.currencyexchange.dto.CurrencyDTO;
import com.dolgosheev.currencyexchange.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping("/currencies")
    public List<CurrencyDTO> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @GetMapping("/currency/{code}")
    public CurrencyDTO getCurrency(@PathVariable String code) {
        return currencyService.getCurrencyByCode(code);
    }

    @PostMapping("/currencies")
    public ResponseEntity<CurrencyDTO> createCurrency(@RequestParam String name,
                                                      @RequestParam String code,
                                                      @RequestParam String sign) {
        CurrencyDTO currencyDto = new CurrencyDTO();
        currencyDto.setName(name);
        currencyDto.setCode(code);
        currencyDto.setSign(sign);

        return new ResponseEntity<>(currencyService.createCurrency(currencyDto), HttpStatus.CREATED);
    }
}
