package com.dolgosheev.currencyexchange.repository;

import com.dolgosheev.currencyexchange.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
