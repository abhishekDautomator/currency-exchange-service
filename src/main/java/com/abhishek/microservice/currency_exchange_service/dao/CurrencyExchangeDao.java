package com.abhishek.microservice.currency_exchange_service.dao;

import com.abhishek.microservice.currency_exchange_service.entity.CurrencyExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeDao extends JpaRepository<CurrencyExchangeEntity, Long> {
}
