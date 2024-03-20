package com.example.configurationapi.repository;

import com.example.configurationapi.model.DeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceRepository extends JpaRepository<DeviceModel, Long> {


    /**
     * Finds a device unique identifier
     *
     * @param deviceId The unique identifier of the device
     * @return An optional containing the found device or empty of no device found
     */
    Optional<DeviceModel> findByIdentifier(String deviceId);

}
