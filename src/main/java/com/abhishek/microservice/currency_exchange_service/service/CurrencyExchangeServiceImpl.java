package com.abhishek.microservice.currency_exchange_service.service;

import com.abhishek.microservice.currency_exchange_service.dao.CurrencyExchangeDao;
import com.abhishek.microservice.currency_exchange_service.entity.CurrencyExchangeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService{

    @Autowired
    CurrencyExchangeDao currencyExchangeDao;

    @Autowired
    Environment environment;

    @Override
    public CurrencyExchangeEntity getCurrencyExchange(String from, String to) {
        CurrencyExchangeEntity currencyExchangeEntity = new CurrencyExchangeEntity();
        String env = environment.getProperty("local.server.port");
        currencyExchangeEntity.setEnvironment(env);
        if(from.equalsIgnoreCase("usd") && to.equalsIgnoreCase("inr")){
            currencyExchangeEntity.setConversionMultiple(BigDecimal.valueOf(70));
        }
        currencyExchangeEntity.setFrom(from);
        currencyExchangeEntity.setTo(to);
        return currencyExchangeDao.save(currencyExchangeEntity);
    }
}
