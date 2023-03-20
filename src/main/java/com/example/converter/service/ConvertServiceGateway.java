package com.example.converter.service;

import com.example.converter.entity.AuditLog;
import com.example.converter.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceGateway {

    private final DecimalToRomanNumeralConverterService decimalToRomanConverter;
    private final BinaryToRomanNumeralConverterService binaryToRomanConverter;
    private final AuditLogRepository auditLogRepository;

    public ConvertServiceGateway(DecimalToRomanNumeralConverterService decimalToRomanConverter,
                                 BinaryToRomanNumeralConverterService binaryToRomanConverter,
                                 AuditLogRepository auditLogRepository) {
        this.decimalToRomanConverter = decimalToRomanConverter;
        this.binaryToRomanConverter = binaryToRomanConverter;
        this.auditLogRepository = auditLogRepository;
    }

    public String convertToRomanNumeral(String input, String type) {
        RomanNumeralConverter converter = getConverter(type);
        int parsedInput = converter.parseToInteger(input);
        String result = converter.convertToRoman(parsedInput);
        logConversion(input, result, type);
        return result;
    }

    private RomanNumeralConverter getConverter(String type) {
        return switch (type) {
            case "decimal" -> decimalToRomanConverter;
            case "binary" -> binaryToRomanConverter;
            default -> throw new IllegalArgumentException("Invalid conversion type");
        };
    }

    public void logConversion(String input, String output, String type) {
        AuditLog log = AuditLog.builder().conversionType(type).input(input).output(output).build();
        auditLogRepository.save(log);
    }
}

