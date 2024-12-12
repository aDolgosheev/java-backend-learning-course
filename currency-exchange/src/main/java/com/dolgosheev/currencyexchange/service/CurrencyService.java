package com.dolgosheev.currencyexchange.service;

import com.dolgosheev.currencyexchange.dto.CurrencyDTO;
import com.dolgosheev.currencyexchange.entity.Currency;
import com.dolgosheev.currencyexchange.exception.CurrencyAlreadyExistsException;
import com.dolgosheev.currencyexchange.exception.CurrencyNotFoundException;
import com.dolgosheev.currencyexchange.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public List<CurrencyDTO> getAllCurrencies() {
        return currencyRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CurrencyDTO getCurrencyByCode(String code) {
        Currency currency = currencyRepository.findByCode(code)
                .orElseThrow(() -> new CurrencyNotFoundException("Валюта с кодом " + code + " не найдена"));
        return convertToDTO(currency);
    }

    public CurrencyDTO createCurrency(CurrencyDTO currencyDTO) {
        if (currencyRepository.existsByCode(currencyDTO.getCode())) {
            throw new CurrencyAlreadyExistsException("Валюта с кодом " + currencyDTO.getCode() + " уже существует");
        }

        Currency currency = new Currency();
        currency.setCode(currencyDTO.getCode());
        currency.setFullName(currencyDTO.getName());
        currency.setSign(currencyDTO.getSign());

        Currency savedCurrency = currencyRepository.save(currency);
        return convertToDTO(savedCurrency);
    }

    private CurrencyDTO convertToDTO(Currency currency) {
        CurrencyDTO dto = new CurrencyDTO();
        dto.setId(currency.getId());
        dto.setCode(currency.getCode());
        dto.setName(currency.getFullName());
        dto.setSign(currency.getSign());
        return dto;
    }

}
