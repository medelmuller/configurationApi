package com.example.configurationapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ADDRESS")
public class AddressModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 128)
    private String name;

    @Column(name = "STREET", length = 128, nullable = false)
    private String street;

    @Column(name = "BUILDING_NUMBER", length = 128, nullable = false)
    private String buildingNumber;

    @Column(name = "APARTAMENT_NUMBER", length = 128)
    private String apartamentNumber;

    @Column(name = "CITY", length = 128, nullable = false)
    private String city;

    @Column(name = "POSTAL_CODE", length = 128, nullable = false)
    private String postalCode;

    @Column(name = "COUNTRY", length = 128, nullable = false)
    private String country;


}
