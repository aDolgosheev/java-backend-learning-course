package com.dolgosheev.currencyexchange.repository;

import com.dolgosheev.currencyexchange.entity.Currency;
import com.dolgosheev.currencyexchange.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findByBaseCurrencyAndTargetCurrency(Currency baseCurrency, Currency targetCurrency);
    Optional<ExchangeRate> findByBaseCurrency_CodeAndTargetCurrency_Code(String baseCode, String targetCode);
}
