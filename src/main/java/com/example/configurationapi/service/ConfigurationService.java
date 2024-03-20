package com.example.configurationapi.service;

import com.example.configurationapi.dto.ConfigurationReadDto;
import com.example.configurationapi.model.ConfigurationModel;
import com.example.configurationapi.model.DeviceModel;
import com.example.configurationapi.repository.ConfigurationRepository;
import com.example.configurationapi.utils.mapper.ConfigurationMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfigurationService {


    private final ConfigurationRepository configurationRepository;
    private final DeviceService deviceService;
    private final ConfigurationMapper configurationMapper;

    /**
     * Creates a configuration for a device
     *
     * @param deviceId          The identifier od the device fot which the configuration is created
     * @param configurationJson The configurations details in JSON format
     * @return The created ConfigurationModel object
     */
    public ConfigurationModel createConfiguration(String deviceId, String configurationJson) {
        DeviceModel device = deviceService.findOrCreateDevice(deviceId);
        ConfigurationModel configuration = buildConfiguration(deviceId, device, configurationJson);
        return configurationRepository.save(configuration);
    }


    /**
     * Builds a new ConfigurationModel object with the provided details.
     *
     * @param deviceId          The identifier of the device for which the configuration is being created
     * @param device            The DeviceModel object corresponding to the provided deviceId
     * @param configurationJson The configuration details in JSON format
     * @return A new ConfigurationModel object populated with the provided details
     */
    private ConfigurationModel buildConfiguration(String deviceId, DeviceModel device, String configurationJson) {
        ConfigurationModel configuration = new ConfigurationModel();
        configuration.setIdentifier(deviceId);
        configuration.setDevice(device);
        configuration.setConfiguration(configurationJson);
        return configuration;
    }


    /**
     * Retrieves a configuration by its unique identifier and converts it to a DTO
     *
     * @param id The unique identifier of the configuration to retrieve
     * @return The ConfigurationReadDto corresponding to the requested configuration
     * @throws EntityNotFoundException if no configuration id found with the provided id
     */
    public ConfigurationReadDto getConfigurationById(Long id) {
        return configurationRepository.findById(id)
                .map(configurationMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Configuration not found"));


    }


    /**
     * Updates an existing configuration with new details
     *
     * @param id                The unique identifier of the configuration to update
     * @param configurationJson The new configuration details in JSON format
     * @return The update ConfigurationModel object
     * @throws EntityNotFoundException if no configuration is found with the provided id
     */
    public ConfigurationModel updateConfiguration(Long id, String configurationJson) {
        ConfigurationModel configuration = configurationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Configuration not found"));
        configuration.setConfiguration(configurationJson);
        return configurationRepository.save(configuration);
    }


    /**
     * Deletes a configuration by its unique identifier
     *
     * @param id The unique identifier of the configuration to delete
     * @throws EntityNotFoundException if no configuration is found with the provided id
     */
    public void deleteConfiguration(Long id) {
        if (!configurationRepository.existsById(id)) {
            throw new EntityNotFoundException("Configuration not found");
        }
        configurationRepository.deleteById(id);
    }
}
