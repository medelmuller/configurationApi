package com.example.configurationapi.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "DEVICE")
public class DeviceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IDENTIFIER", unique = true, length = 128, nullable = false)
    private String identifier;

    @Column(name = "CREATION_DATE", nullable = false)
    private ZonedDateTime creationDate;

    @Column(name = "MODIFICATION_DATE")
    private ZonedDateTime modificationDate;

    @Column(name = "LAUNCH_DATE")
    private ZonedDateTime launchDate;

    @Column(name = "SHUTDOWN_DATE")
    private ZonedDateTime shutdownDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressModel address;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ConfigurationModel> configurations = new HashSet<>();


    @PrePersist
    protected void onCreate() {
        this.creationDate = ZonedDateTime.now();
    }


    @PreUpdate
    protected void onUpdate() {
        this.modificationDate = ZonedDateTime.now();
    }
}
