package com.administracion.bd.location_country;

import jakarta.persistence.*;

@Entity
@Table(name = "LOCATION_COUNTRY")
public class LocationCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_COUNTRY_ID")
    private Long locationCountryId;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    public Long getLocationCountryId() {
        return locationCountryId;
    }

    public void setLocationCountryId(Long locationCountryId) {
        this.locationCountryId = locationCountryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
