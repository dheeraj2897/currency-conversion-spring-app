package com.dheeraj.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dheeraj.microservices.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	public CurrencyExchange findByFromAndTo(String from, String to);
}
