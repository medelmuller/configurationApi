package com.example.configurationapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigurationReqDto {

    @NotBlank(message = "Identifier is required")
    private String identifier;

    @NotBlank(message = "Configuration is required")
    private String configuration;
}
