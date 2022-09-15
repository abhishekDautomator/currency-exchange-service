package com.abhishek.microservice.currency_exchange_service.service;

import com.abhishek.microservice.currency_exchange_service.dao.CurrencyExchangeDao;
import com.abhishek.microservice.currency_exchange_service.entity.CurrencyExchangeEntity;

public interface CurrencyExchangeService{
    CurrencyExchangeEntity getCurrencyExchange(String from, String to);
}
