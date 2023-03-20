package com.example.converter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "audit_log")
public class AuditLog extends AbstractEntity {

    @Column(name = "conversion_type", nullable = false)
    private String conversionType;

    @Column(name = "input_value", nullable = false)
    private String input;

    @Column(name = "output_value", nullable = false)
    private String output;
}
