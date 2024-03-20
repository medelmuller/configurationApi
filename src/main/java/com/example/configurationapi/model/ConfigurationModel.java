package com.example.configurationapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Data
@Table(name = "CONFIGURATION")
public class ConfigurationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IDENTIFIER", unique = true, length = 128, nullable = false)
    private String identifier;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id", nullable = false)
    private DeviceModel device;

    @Column(name = "CONFIGURATION", columnDefinition = "TEXT", nullable = false)
    private String configuration;

    @Column(name = "CREATION_DATE", nullable = false)
    private ZonedDateTime creationDate;

    @Column(name = "MODIFICATION_DATE", nullable = false)
    private ZonedDateTime modificationDate;


    @PrePersist
    protected void onCreate() {
        creationDate = ZonedDateTime.now();
        this.modificationDate = this.creationDate;
    }


    @PreUpdate
    protected void onUpdate() {
        this.modificationDate = ZonedDateTime.now();
    }
}
