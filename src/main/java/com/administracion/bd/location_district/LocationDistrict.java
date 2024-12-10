package com.administracion.bd.location_district;

import com.administracion.bd.location_canton.LocationCanton;
import jakarta.persistence.*;

@Entity
@Table(name = "LOCATION_DISTRICT")
public class LocationDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_DISTRICT_ID")
    private Long locationDistrictId;

    @Column(name = "DISTRICT_NAME", nullable = false, length = 255)
    private String districtName;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(
        name = "LOCATION_CANTON_ID",
        referencedColumnName = "LOCATION_CANTON_ID",
        foreignKey = @ForeignKey(name = "FK_LOCATION_DISTRICT_CANTON")
    )
    private LocationCanton locationCanton;

    
    public Long getLocationDistrictId() {
        return locationDistrictId;
    }

    public void setLocationDistrictId(Long locationDistrictId) {
        this.locationDistrictId = locationDistrictId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public LocationCanton getLocationCanton() {
        return locationCanton;
    }

    public void setLocationCanton(LocationCanton locationCanton) {
        this.locationCanton = locationCanton;
    }
}
