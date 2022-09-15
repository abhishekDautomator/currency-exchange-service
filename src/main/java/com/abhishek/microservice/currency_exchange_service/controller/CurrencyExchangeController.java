package com.abhishek.microservice.currency_exchange_service.controller;

import com.abhishek.microservice.currency_exchange_service.entity.CurrencyExchangeEntity;
import com.abhishek.microservice.currency_exchange_service.service.CurrencyExchangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeServiceImpl currencyExchangeServiceImpl;

    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<Object> getCurrencyExchangeDetails(@PathVariable String from, @PathVariable String to){
        CurrencyExchangeEntity currencyExchangeEntity = currencyExchangeServiceImpl.getCurrencyExchange(from, to);
        if(currencyExchangeEntity.getConversionMultiple()!=null)
            return new ResponseEntity(currencyExchangeEntity, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity("This is a dummy service, please enter 'from' as USD and 'to' as INR",HttpStatus.NOT_FOUND);
    }
}
