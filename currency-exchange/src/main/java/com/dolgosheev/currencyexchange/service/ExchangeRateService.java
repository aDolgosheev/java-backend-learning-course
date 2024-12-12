package com.dolgosheev.currencyexchange.service;

import com.dolgosheev.currencyexchange.dto.CurrencyDTO;
import com.dolgosheev.currencyexchange.dto.ExchangeRateDTO;
import com.dolgosheev.currencyexchange.entity.Currency;
import com.dolgosheev.currencyexchange.entity.ExchangeRate;
import com.dolgosheev.currencyexchange.exception.ExchangeRateNotFoundException;
import com.dolgosheev.currencyexchange.repository.CurrencyRepository;
import com.dolgosheev.currencyexchange.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;
    private final CurrencyRepository currencyRepository;

    public List<ExchangeRateDTO> getAllExchangeRates() {
        return exchangeRateRepository.findAll().stream()
                .map(this::convertToDtoExchangeRate)
                .collect(Collectors.toList());
    }

    public ExchangeRateDTO getExchangeRate(String baseCode, String targetCode) {
        Currency baseCurrency = currencyRepository.findByCode(baseCode)
                .orElseThrow(() -> new ExchangeRateNotFoundException("Базовая валюта не найдена"));
        Currency targetCurrency = currencyRepository.findByCode(targetCode)
                .orElseThrow(() -> new ExchangeRateNotFoundException("Целевая валюта не найдена"));

        ExchangeRate rate = exchangeRateRepository
                .findByBaseCurrencyAndTargetCurrency(baseCurrency, targetCurrency)
                .orElseThrow(() -> new ExchangeRateNotFoundException("Курс обмена не найден"));

        return convertToDtoExchangeRate(rate);
    }

    public ExchangeRateDTO createExchangeRate(String baseCode, String targetCode, BigDecimal rate) {
        Currency baseCurrency = currencyRepository.findByCode(baseCode)
                .orElseThrow(() -> new ExchangeRateNotFoundException("Базовая валюта не найдена"));
        Currency targetCurrency = currencyRepository.findByCode(targetCode)
                .orElseThrow(() -> new ExchangeRateNotFoundException("Целевая валюта не найдена"));

        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setBaseCurrency(baseCurrency);
        exchangeRate.setTargetCurrency(targetCurrency);
        exchangeRate.setRate(rate);

        return convertToDtoExchangeRate(exchangeRateRepository.save(exchangeRate));
    }

    public ExchangeRateDTO updateExchangeRate(String baseCode, String targetCode, BigDecimal newRate) {
        ExchangeRate rate = exchangeRateRepository
                .findByBaseCurrency_CodeAndTargetCurrency_Code(baseCode, targetCode)
                .orElseThrow(() -> new ExchangeRateNotFoundException("Курс обмена не найден"));

        rate.setRate(newRate);
        return convertToDtoExchangeRate(exchangeRateRepository.save(rate));
    }

    public BigDecimal calculateExchange(String fromCode, String toCode, BigDecimal amount) {
        BigDecimal rate = findExchangeRate(fromCode, toCode);
        return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal findExchangeRate(String fromCode, String toCode) {
        // Прямой курс
        Optional<ExchangeRate> directRate = exchangeRateRepository
                .findByBaseCurrency_CodeAndTargetCurrency_Code(fromCode, toCode);
        if (directRate.isPresent()) {
            return directRate.get().getRate();
        }

        // Обратный курс
        Optional<ExchangeRate> reverseRate = exchangeRateRepository
                .findByBaseCurrency_CodeAndTargetCurrency_Code(toCode, fromCode);
        if (reverseRate.isPresent()) {
            return BigDecimal.ONE.divide(reverseRate.get().getRate(), 6, RoundingMode.HALF_UP);
        }

        // Кросс-курс через USD
        Optional<ExchangeRate> usdToFrom = exchangeRateRepository
                .findByBaseCurrency_CodeAndTargetCurrency_Code("USD", fromCode);
        Optional<ExchangeRate> usdToTo = exchangeRateRepository
                .findByBaseCurrency_CodeAndTargetCurrency_Code("USD", toCode);

        if (usdToFrom.isPresent() && usdToTo.isPresent()) {
            return usdToTo.get().getRate()
                    .divide(usdToFrom.get().getRate(), 6, RoundingMode.HALF_UP);
        }

        throw new ExchangeRateNotFoundException("Не удалось найти подходящий курс обмена");
    }

    private ExchangeRateDTO convertToDtoExchangeRate(ExchangeRate rate) {
        ExchangeRateDTO dto = new ExchangeRateDTO();
        dto.setId(rate.getId());
        dto.setBaseCurrency(convertToDTOCurrency(rate.getBaseCurrency()));
        dto.setTargetCurrency(convertToDTOCurrency(rate.getTargetCurrency()));
        dto.setRate(rate.getRate());
        return dto;
    }

    private CurrencyDTO convertToDTOCurrency(Currency currency) {
        CurrencyDTO dto = new CurrencyDTO();
        dto.setId(currency.getId());
        dto.setCode(currency.getCode());
        dto.setName(currency.getFullName());
        dto.setSign(currency.getSign());
        return dto;
    }
}
