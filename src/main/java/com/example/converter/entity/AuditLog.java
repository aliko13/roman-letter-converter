package com.example.converter.entity;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog extends AbstractEntity {

    @Column(name = "conversion_type", nullable = false)
    private String conversionType;

    @Column(name = "input", nullable = false)
    private String input;

    @Column(name = "output", nullable = false)
    private String output;
}
