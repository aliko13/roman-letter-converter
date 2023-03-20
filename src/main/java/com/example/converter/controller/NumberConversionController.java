package com.example.converter.controller;

import com.example.converter.service.ConvertServiceGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberConversionController {

    private final ConvertServiceGateway convertServiceGateway;

    public NumberConversionController(ConvertServiceGateway convertServiceGateway) {
        this.convertServiceGateway = convertServiceGateway;
    }

    @GetMapping("/convert")
    public String convertNumber(@RequestParam String input, @RequestParam String type) {
        return convertServiceGateway.convertToRomanNumeral(input, type);
    }
}
