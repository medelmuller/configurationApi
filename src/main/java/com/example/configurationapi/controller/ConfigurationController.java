package com.example.configurationapi.controller;


import com.example.configurationapi.dto.ConfigurationReadDto;
import com.example.configurationapi.dto.ConfigurationReqDto;
import com.example.configurationapi.model.ConfigurationModel;
import com.example.configurationapi.service.ConfigurationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configurations")
@RequiredArgsConstructor
@Tag(name = "Configuration Controller", description = "Endpoints for mapping configurations")
public class ConfigurationController {

    private final ConfigurationService configurationService;


    /**
     * Creates a new device configuration based on the provided data.
     *
     * @param request Data required to create the configuration
     * @return The created configuration with HTTP status 201.
     */
    @Operation(summary = "Create configuration", description = "Creates a new device configuration based on the provided data.")
    @PostMapping
    public ResponseEntity<ConfigurationModel> createConfiguration(@Valid @RequestBody ConfigurationReqDto request) {
        ConfigurationModel configuration = configurationService.createConfiguration(request.getIdentifier(), request.getConfiguration());
        return new ResponseEntity<>(configuration, HttpStatus.CREATED);
    }


    /**
     * Retrieves a configuration by its ID
     *
     * @param id The ID of the configuration to retrieve
     * @return The requested configuration if found, with HTTP status 200
     */
    @Operation(summary = "Get Configuration", description = "Retrieves a configuration by its ID")
    @GetMapping("/{id}")
    public ResponseEntity<ConfigurationReadDto> getConfiguration(@PathVariable Long id) {
        ConfigurationReadDto configuration = configurationService.getConfigurationById(id);
        return ResponseEntity.ok(configuration);
    }


    /**
     * Updates an existing configuration with new data
     *
     * @param id      The ID of the configuration to update
     * @param request Data required for updating the configuration
     * @return The updated configuration with HTTP status 200
     */
    @Operation(summary = "Update Configuration", description = "Updates an existing configuration with new data")
    @PutMapping("/{id}")
    public ResponseEntity<ConfigurationModel> updateConfiguration(@PathVariable Long id, @Valid @RequestBody ConfigurationReqDto request) {
        ConfigurationModel updateConfiguration = configurationService.updateConfiguration(id, request.getConfiguration());
        return ResponseEntity.ok(updateConfiguration);
    }


    /**
     * Delete a configuration by its ID
     *
     * @param id The ID of the configuration to delete
     * @return HTTP status 204 with no content it the deletion was successful
     */
    @Operation(summary = "Delete Configuration", description = "Deletes a configuration by its ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConfiguration(@PathVariable Long id) {
        configurationService.deleteConfiguration(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
