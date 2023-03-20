package com.example.converter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryToRomanNumeralConverterServiceTest {

    private BinaryToRomanNumeralConverterService converter;

    @BeforeEach
    void setUp() {
        converter = new BinaryToRomanNumeralConverterService();
    }

    @Test
    void testConvertToRoman() {
        // given
        int number = 1010;

        // when
        String result = converter.convertToRoman(1010);

        // then
        assertEquals("MX", result);
    }

    @Test
    void testParseToInteger() {
        // given
        String number = "1010";

        // when
        int result = converter.parseToInteger("1010");

        // then
        assertEquals(10, result);
    }
}

