package com.example.converter.controller;

import com.example.converter.enums.ConverterType;
import com.example.converter.service.ConvertServiceGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class NumberConversionController {

    private final ConvertServiceGateway convertServiceGateway;

    public NumberConversionController(ConvertServiceGateway convertServiceGateway) {
        this.convertServiceGateway = convertServiceGateway;
    }

    @GetMapping("/convert")
    public String convertNumber(@RequestParam String input, @RequestParam ConverterType type) {
        return convertServiceGateway.convertToRomanNumeral(input, type);
    }

    @GetMapping("/convert/types")
    public List<ConverterType> getConvertTypes() {
        return Arrays.stream(ConverterType.values()).toList();
    }
}
