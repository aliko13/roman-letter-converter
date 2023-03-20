package com.example.converter.entity;

import com.example.converter.enums.ConverterType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "audit_log")
public class AuditLog extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "conversion_type", nullable = false)
    private ConverterType conversionType;

    @Column(name = "input_value", nullable = false)
    private String input;

    @Column(name = "output_value", nullable = false)
    private String output;
}
