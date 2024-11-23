package com.dolgosheev.currencyexchange.repository;

import com.dolgosheev.currencyexchange.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
}
