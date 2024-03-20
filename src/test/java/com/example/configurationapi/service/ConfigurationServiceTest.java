package com.example.configurationapi.service;

import com.example.configurationapi.model.ConfigurationModel;
import com.example.configurationapi.model.DeviceModel;
import com.example.configurationapi.repository.ConfigurationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConfigurationServiceTest {


    @Mock
    private ConfigurationRepository configurationRepository;

    @Mock
    private DeviceService deviceService;

    @InjectMocks
    private ConfigurationService configurationService;

    @Test
    public void createConfiguration_ShouldSaveConfiguration() {
        // Utworzenie mocka modelu urządzenia z określonym identyfikatorem.
        DeviceModel mockDevice = new DeviceModel();
        mockDevice.setIdentifier("device123");

        ConfigurationModel mockConfiguration = new ConfigurationModel();
        mockConfiguration.setIdentifier("device123");
        mockConfiguration.setConfiguration("{\"setting\":\"value\"}");

        when(deviceService.findOrCreateDevice(any(String.class))).thenReturn(mockDevice);

        when(configurationRepository.save(any(ConfigurationModel.class))).thenReturn(mockConfiguration);

        configurationService.createConfiguration("device123", "{\"setting\":\"value\"}");
        verify(configurationRepository).save(any(ConfigurationModel.class));
    }

    @Test
    void createConfiguration_ShouldHandleDeviceServiceExceptions() {
        // Dane wejściowe to ID urządzenia i JSON konfiguracji
        String deviceId = "device123";
        String configurationJson = "{\"setting\":\"value\"}";

        // Konfigurujemy `deviceService` aby rzucił wyjątek
        when(deviceService.findOrCreateDevice(anyString())).thenThrow(new RuntimeException("Nieoczekiwany błąd"));

        // Weryfikujemy, że `configurationService` odpowiednio obsługuje lub propaguje wyjątek
        assertThrows(RuntimeException.class, () -> configurationService.createConfiguration(deviceId, configurationJson));

        // Upewnij się, że nie próbowano zapisać konfiguracji, gdy `deviceService` zakończył się błędem
        verify(configurationRepository, never()).save(any(ConfigurationModel.class));
    }

    @Test
    void updateConfiguration_ShouldUpdateAndReturnConfiguration() {
        // Dane testowe
        Long id = 1L;
        String configurationJson = "{\"newSetting\":\"newValue\"}";
        ConfigurationModel configurationModel = new ConfigurationModel();

        // Konfiguracja zachowań mocków
        when(configurationRepository.findById(id)).thenReturn(Optional.of(configurationModel));
        when(configurationRepository.save(any(ConfigurationModel.class))).thenReturn(configurationModel);

        // Wywołanie metody testowanej
        ConfigurationModel result = configurationService.updateConfiguration(id, configurationJson);

        // Weryfikacja wyniku
        assertNotNull(result);
        assertEquals(configurationJson, result.getConfiguration());
    }


    @Test
    void updateConfiguration_ShouldThrowExceptionWhenNotFound() {
        // Dane testowe
        Long id = 1L;
        String configurationJson = "{\"newSetting\":\"newValue\"}";

        // Konfiguracja zachowań mocków
        when(configurationRepository.findById(id)).thenReturn(Optional.empty());

        // Wywołanie metody testowanej i weryfikacja wyjątku
        assertThrows(EntityNotFoundException.class, () -> configurationService.updateConfiguration(id, configurationJson));
    }


    @Test
    void deleteConfiguration_ShouldDeleteWhenFound() {
        // Dane testowe
        Long id = 1L;

        // Konfiguracja zachowań mocków
        when(configurationRepository.existsById(id)).thenReturn(true);

        // Wywołanie metody testowanej
        configurationService.deleteConfiguration(id);

        // Weryfikacja, czy metoda deleteById została wywołana
        verify(configurationRepository).deleteById(id);
    }


    @Test
    void deleteConfiguration_ShouldThrowExceptionWhenNotFound() {
        // Dane testowe
        Long id = 1L;

        // Konfiguracja zachowań mocków
        when(configurationRepository.existsById(id)).thenReturn(false);

        // Wywołanie metody testowanej i weryfikacja wyjątku
        assertThrows(EntityNotFoundException.class, () -> configurationService.deleteConfiguration(id));
    }
}