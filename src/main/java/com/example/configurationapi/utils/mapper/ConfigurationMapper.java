package com.example.configurationapi.utils.mapper;


import com.example.configurationapi.dto.ConfigurationReadDto;
import com.example.configurationapi.model.ConfigurationModel;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class ConfigurationMapper {

    /**
     * Converts a ConfigurationModel entity to a ConfigurationReadDto
     *
     * @param model the configurationModel entity to convert
     * @return The converted ConfigurationReadDto
     */

/*    public ConfigurationReadDto toDto(ConfigurationModel model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        String formattedDate = model.getCreationDate().format(formatter);
        return new ConfigurationReadDto(model.getConfiguration(), formattedDate);
    }*/


    public ConfigurationReadDto toDto(ConfigurationModel model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        String formattedDate = model.getCreationDate().format(formatter);
        return ConfigurationReadDto.builder()
                .configuration(model.getConfiguration())
                .creationDate(formattedDate)
                .build();
    }


}
