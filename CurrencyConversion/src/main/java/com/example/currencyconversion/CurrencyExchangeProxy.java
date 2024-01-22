package com.example.currencyconversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//Feign projesinin amacı java http clientlarını kolayca oluşturmayı sağlamaktır.
//diger servicellere requestleri burdan atiriq
//@FeignClient(name = "currency-exchange",url = "http://localhost:8000")
@FeignClient(name = "currency-exchange")  //artiq naming server(service registry) vasitelise yuxardaki kimi yox bele yaza bilerik, eureka ile danisir bilir urlini yerini filan
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
//naming server portlarin falan meselen currencyExchangeproxy de hard code (http://localhost:8000) yazmadan briyerden idare etmek ucundu