package com.example.configurationapi.controller;

import com.example.configurationapi.dto.ConfigurationReadDto;
import com.example.configurationapi.dto.ConfigurationReqDto;
import com.example.configurationapi.model.ConfigurationModel;
import com.example.configurationapi.service.ConfigurationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConfigurationControllerTest {

    @Mock
    private ConfigurationService configurationService;

    @InjectMocks
    private ConfigurationController configurationController;

    @Test
    void createConfiguration_ShouldReturnCreatedConfiguration() {
        // Dane testowe
        ConfigurationReqDto requestDto = new ConfigurationReqDto();
        requestDto.setIdentifier("testIdentifier");
        requestDto.setConfiguration("{\"setting\":\"value\"}");

        ConfigurationModel createdConfiguration = new ConfigurationModel();
        createdConfiguration.setIdentifier(requestDto.getIdentifier());
        createdConfiguration.setConfiguration(requestDto.getConfiguration());

        when(configurationService.createConfiguration(requestDto.getIdentifier(), requestDto.getConfiguration()))
                .thenReturn(createdConfiguration);

        // Wywołanie metody testowanej
        ResponseEntity<ConfigurationModel> response = configurationController.createConfiguration(requestDto);

        // Weryfikacja odpowiedzi
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdConfiguration, response.getBody());
    }

    @Test
    void getConfiguration_ShouldReturnRequestedConfiguration() {
        // Dane testowe
        Long id = 1L;
        ConfigurationReadDto readDto = new ConfigurationReadDto("testConfiguration", "2023-02-19");

        when(configurationService.getConfigurationById(id)).thenReturn(readDto);

        // Wywołanie metody testowanej
        ResponseEntity<ConfigurationReadDto> response = configurationController.getConfiguration(id);

        // Weryfikacja odpowiedzi
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(readDto, response.getBody());
    }

    @Test
    void updateConfiguration_ShouldReturnUpdatedConfiguration() {
        // Dane testowe
        Long id = 1L;
        ConfigurationReqDto requestDto = new ConfigurationReqDto();
        requestDto.setConfiguration("{\"newSetting\":\"newValue\"}");

        ConfigurationModel updatedConfiguration = new ConfigurationModel();
        updatedConfiguration.setConfiguration(requestDto.getConfiguration());

        when(configurationService.updateConfiguration(id, requestDto.getConfiguration()))
                .thenReturn(updatedConfiguration);

        // Wywołanie metody testowanej
        ResponseEntity<ConfigurationModel> response = configurationController.updateConfiguration(id, requestDto);

        // Weryfikacja odpowiedzi
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedConfiguration, response.getBody());
    }

    @Test
    void deleteConfiguration_ShouldReturnNoContent() {
        // Dane testowe
        Long id = 1L;

        // Wywołanie metody testowanej
        ResponseEntity<Void> response = configurationController.deleteConfiguration(id);

        // Weryfikacja odpowiedzi
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(configurationService).deleteConfiguration(id);
    }
}