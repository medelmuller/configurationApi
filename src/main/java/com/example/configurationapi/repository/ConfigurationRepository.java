package com.example.configurationapi.repository;

import com.example.configurationapi.model.ConfigurationModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConfigurationRepository extends JpaRepository<ConfigurationModel, Long> {
}
