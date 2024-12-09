package com.administracion.bd.location;

import com.administracion.bd.user.User;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "LOCATION")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_ID", nullable = false)
    private Long locationId;

    @Column(name = "LOCATION_COUNTRY_ID")
    private Long locationCountryId;

    @Column(name = "LOCATION_PROVINCE_ID")
    private Long locationProvinceId;

    @Column(name = "LOCATION_CANTON_ID")
    private Long locationCantonId;

    @Column(name = "LOCATION_DISTRICT_ID")
    private Long locationDistrictId;

    @Column(name = "OTHER_DETAILS", length = 255)
    private String otherDetails;

   
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

   
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getLocationCountryId() {
        return locationCountryId;
    }

    public void setLocationCountryId(Long locationCountryId) {
        this.locationCountryId = locationCountryId;
    }

    public Long getLocationProvinceId() {
        return locationProvinceId;
    }

    public void setLocationProvinceId(Long locationProvinceId) {
        this.locationProvinceId = locationProvinceId;
    }

    public Long getLocationCantonId() {
        return locationCantonId;
    }

    public void setLocationCantonId(Long locationCantonId) {
        this.locationCantonId = locationCantonId;
    }

    public Long getLocationDistrictId() {
        return locationDistrictId;
    }

    public void setLocationDistrictId(Long locationDistrictId) {
        this.locationDistrictId = locationDistrictId;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }
}
