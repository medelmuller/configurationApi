package com.example.configurationapi.service;

import com.example.configurationapi.model.DeviceModel;
import com.example.configurationapi.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {


    private final DeviceRepository deviceRepository;

    /**
     * Finds an existing device by its identifier ao creates a new one if does not exist.
     *
     * @param deviceId The unique identifie od the device
     * @return The found or newly created DeviceModel object
     */
    public DeviceModel findOrCreateDevice(String deviceId) {
        return deviceRepository.findByIdentifier(deviceId)
                .orElseGet(() -> createNewDevice(deviceId));

    }


    /**
     * Creates a new device entity with the given identifier
     *
     * @param deviceId The unique identifier for the new device
     * @return The newly created DeviceModel object
     */
    private DeviceModel createNewDevice(String deviceId) {
        DeviceModel newDevice = new DeviceModel();
        newDevice.setIdentifier(deviceId);
        return deviceRepository.save(newDevice);
    }
}
