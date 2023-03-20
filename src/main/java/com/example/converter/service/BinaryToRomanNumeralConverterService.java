package com.example.converter.service;

import org.springframework.stereotype.Component;

@Component
public class BinaryToRomanNumeralConverterService implements RomanNumeralConverter {
    @Override
    public String convertToRoman(int number) {
        return RomanNumeralConverter.super.convertToRoman(number);
    }

    @Override
    public int parseToInteger(String number) {
        return Integer.parseInt(number, 2);
    }
}