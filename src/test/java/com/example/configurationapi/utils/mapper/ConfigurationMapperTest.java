package com.example.configurationapi.utils.mapper;

import com.example.configurationapi.dto.ConfigurationReadDto;
import com.example.configurationapi.model.ConfigurationModel;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationMapperTest {

    private final ConfigurationMapper mapper = new ConfigurationMapper();

    @Test
    public void toDto_ShouldCorrectlyConvertModelToDto() {
        // Given: Utworzenie modelu ConfigurationModel z określonymi danymi
        ConfigurationModel model = new ConfigurationModel();
        model.setConfiguration("{\"key\":\"value\"}");
        ZonedDateTime now = ZonedDateTime.now();
        model.setCreationDate(now);

        // Expected: Oczekiwany format daty
        String expectedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // When: Wywołanie metody toDto mappera
        ConfigurationReadDto dto = mapper.toDto(model);

        // Then: Weryfikacja, czy DTO zostało poprawnie utworzone
        assertEquals("{\"key\":\"value\"}", dto.getConfiguration());
        assertEquals(expectedDate, dto.getCreationDate());
    }
}