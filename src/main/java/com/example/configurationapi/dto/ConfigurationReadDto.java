package com.example.configurationapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ConfigurationReadDto {


    private String configuration;
    private String creationDate;


}
