package com.example.configurationapi.service;

import com.example.configurationapi.model.DeviceModel;
import com.example.configurationapi.repository.DeviceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeviceServiceTest {


    @Mock
    private DeviceRepository deviceRepository;

    @InjectMocks
    private DeviceService deviceService;

    @Test
    void findOrCreateDevice_ShouldReturnExistingDevice() {
        // Given: Istniejący identyfikator urządzenia
        String deviceId = "existingDevice";

        // Gdy: Urządzenie o podanym identyfikatorze istnieje w repozytorium
        DeviceModel existingDevice = new DeviceModel();
        existingDevice.setIdentifier(deviceId);
        existingDevice.setCreationDate(ZonedDateTime.now());
        existingDevice.setModificationDate(ZonedDateTime.now());
        when(deviceRepository.findByIdentifier(deviceId)).thenReturn(Optional.of(existingDevice));

        // Wtedy: Metoda powinna zwrócić istniejące urządzenie
        DeviceModel resultDevice = deviceService.findOrCreateDevice(deviceId);
        assertEquals(deviceId, resultDevice.getIdentifier());
    }

    @Test
    void findOrCreateDevice_ShouldCreateNewDevice() {
        // Dane testowe
        String deviceId = "newDevice";

        // Gdy: Urządzenie o podanym identyfikatorze nie istnieje w repozytorium
        when(deviceRepository.findByIdentifier(deviceId)).thenReturn(Optional.empty());

        // Oczekujemy, że zostanie zapisane nowe urządzenie
        DeviceModel newDevice = new DeviceModel();
        newDevice.setIdentifier(deviceId);
        when(deviceRepository.save(any(DeviceModel.class))).thenReturn(newDevice);

        // Wtedy: Metoda powinna zwrócić nowo utworzone urządzenie
        DeviceModel resultDevice = deviceService.findOrCreateDevice(deviceId);
        assertEquals(deviceId, resultDevice.getIdentifier());
    }
}