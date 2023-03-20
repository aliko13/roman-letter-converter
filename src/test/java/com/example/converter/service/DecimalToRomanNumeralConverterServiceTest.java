package com.example.converter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecimalToRomanNumeralConverterServiceTest {

    private DecimalToRomanNumeralConverterService converter;

    @BeforeEach
    void setUp() {
        converter = new DecimalToRomanNumeralConverterService();
    }

    @Test
    void testConvertToRoman() {
        // given
        int number = 1666;

        // when
        String result = converter.convertToRoman(1666);

        // then
        assertEquals("MDCLXVI", result);
    }

    @Test
    void testParseToInteger() {
        // given
        String number = "1666";

        // when
        int result = converter.parseToInteger("1666");

        // then
        assertEquals(1666, result);
    }
}

