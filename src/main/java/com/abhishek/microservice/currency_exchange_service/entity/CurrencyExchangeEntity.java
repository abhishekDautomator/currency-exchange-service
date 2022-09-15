package com.abhishek.microservice.currency_exchange_service.entity;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
public class CurrencyExchangeEntity {
    @Id
    @SequenceGenerator(
            initialValue = 1,
            name = "CurrencyExchangeId_Generator"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CurrencyExchangeId_Generator")
    private Long id;
    @Column
    private String from;
    @Column
    private String to;
    @Column
    private BigDecimal conversionMultiple;
    @Column
    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    @Override
    public String toString() {
        return "CurrencyExchangeEntity{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", environment='" + environment + '\'' +
                '}';
    }

    public CurrencyExchangeEntity(Long id, String from, String to, BigDecimal conversionMultiple, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.environment = environment;
    }

    public CurrencyExchangeEntity() {
    }
}
