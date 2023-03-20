package com.example.converter.repository;

import com.example.converter.entity.AuditLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class AuditLogRepositoryTest extends RepositoryTestConfig {

    @Autowired
    private AuditLogRepository repository;

    @Test
    public void shouldSaveAuditLog() {
        // given
        AuditLog log = buildAuditLog();

        // when
        repository.save(log);

        // then
        assertThat(log.getId()).isNotNull();
    }

    @Test
    public void shouldFindAllAuditLogs() {
        // given
        AuditLog firstLog = buildAuditLog();
        AuditLog secondLog = buildAuditLog();

        // when
        repository.saveAllAndFlush(List.of(firstLog, secondLog));

        // then
        assertThat(repository.findAll()).hasSize(2);
    }

    @Test
    public void shouldFindAuditLogById() {
        // given
        AuditLog log = buildAuditLog();

        // when
        repository.save(log);

        // then
        assertThat(repository.findById(log.getId())).isEqualTo(Optional.of(log));
    }

    @Test
    public void shouldUpdateAuditLog() {
        // given
        AuditLog log = buildAuditLog();
        repository.save(log);
        log.setOutput("D");

        // when
        repository.save(log);

        // then
        assertThat(repository.findById(log.getId()).get().getOutput()).isEqualTo("D");
    }

    @Test
    @Modifying
    public void shouldDeleteAuditLog() {
        // given
        AuditLog log = AuditLog.builder().conversionType("decimal").input("100").output("C").build();
        repository.save(log);

        // when
        repository.deleteById(log.getId());

        // then
        assertThat(repository.findById(log.getId())).isEmpty();
    }

    private AuditLog buildAuditLog() {
        return AuditLog.builder()
                .conversionType("decimal")
                .input("100")
                .output("C")
                .build();
    }
}
