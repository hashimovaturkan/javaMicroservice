package com.example.currencyconversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
//Feign projesinin amacı java http clientlarını kolayca oluşturmayı sağlamaktır.
//diger servicellere requestleri burdan atiriq
@FeignClient(name = "currency-exchange",url = "http://localhost:8000")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
