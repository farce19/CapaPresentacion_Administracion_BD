package com.administracion.bd.location_canton;

import jakarta.persistence.*;

@Entity
@Table(name = "LOCATION_CANTON")
public class LocationCanton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_CANTON_ID")
    private Long locationCantonId;

    @Column(name = "CANTON_NAME", nullable = false, length = 255)
    private String cantonName;

    @Column(name = "LOCATION_PROVINCE_ID", nullable = true)
    private Long locationProvinceId;

    // Getters and Setters
    public Long getLocationCantonId() {
        return locationCantonId;
    }

    public void setLocationCantonId(Long locationCantonId) {
        this.locationCantonId = locationCantonId;
    }

    public String getCantonName() {
        return cantonName;
    }

    public void setCantonName(String cantonName) {
        this.cantonName = cantonName;
    }

    public Long getLocationProvinceId() {
        return locationProvinceId;
    }

    public void setLocationProvinceId(Long locationProvinceId) {
        this.locationProvinceId = locationProvinceId;
    }
}
