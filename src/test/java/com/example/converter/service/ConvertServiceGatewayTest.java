package com.example.converter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.example.converter.entity.AuditLog;
import com.example.converter.repository.AuditLogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConvertServiceGatewayTest {

    @Mock
    private DecimalToRomanNumeralConverterService decimalToRomanConverter;

    @Mock
    private BinaryToRomanNumeralConverterService binaryToRomanConverter;

    @Mock
    private AuditLogRepository auditLogRepository;

    @InjectMocks
    private ConvertServiceGateway gateway;

    @Test
    public void shouldConvertDecimalToRomanNumeral() {
        // given
        when(decimalToRomanConverter.parseToInteger("10")).thenReturn(10);
        when(decimalToRomanConverter.convertToRoman(10)).thenReturn("X");

        // when
        String result = gateway.convertToRomanNumeral("10", "decimal");

        // then
        verify(auditLogRepository, times(1)).save(any(AuditLog.class));
        assertEquals("X", result);
    }

    @Test
    public void shouldConvertBinaryToRomanNumeral() {
        // given
        when(binaryToRomanConverter.parseToInteger("1010")).thenReturn(10);
        when(binaryToRomanConverter.convertToRoman(10)).thenReturn("X");

        // when
        String result = gateway.convertToRomanNumeral("1010", "binary");

        // then
        verify(auditLogRepository, times(1)).save(any(AuditLog.class));
        assertEquals("X", result);
    }

    @Test
    public void shouldThrowExceptionForInvalidConversionType() {
        // when / then
        assertThrows(IllegalArgumentException.class,
                () -> gateway.convertToRomanNumeral("10", "invalid"));
    }

    @Test
    public void shouldLogConversion() {
        // given
        when(decimalToRomanConverter.parseToInteger("100")).thenReturn(100);
        when(decimalToRomanConverter.convertToRoman(100)).thenReturn("C");

        // when
        gateway.convertToRomanNumeral("100", "decimal");

        // then
        verify(auditLogRepository, times(1)).save(any(AuditLog.class));
    }

    @Test
    public void shouldNotLogConversionForInvalidConversionType() {
        // when / then
        assertThrows(IllegalArgumentException.class,
                () -> gateway.convertToRomanNumeral("10", "invalid"));
        verify(auditLogRepository, times(0)).save(any(AuditLog.class));
    }

    @Test
    public void shouldNotLogConversionForExceptionThrown() {
        // given
        when(decimalToRomanConverter.parseToInteger("invalid")).thenThrow(NumberFormatException.class);

        // when / then
        assertThrows(NumberFormatException.class, () -> gateway.convertToRomanNumeral("invalid", "decimal"));
        verify(auditLogRepository, times(0)).save(any(AuditLog.class));
    }
}

