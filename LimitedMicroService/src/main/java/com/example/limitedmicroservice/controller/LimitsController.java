package com.example.limitedmicroservice.controller;

import com.example.limitedmicroservice.bean.Limits;
import com.example.limitedmicroservice.configuration.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LimitsController {

    private Configuration configuration;


    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits getLimits(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
