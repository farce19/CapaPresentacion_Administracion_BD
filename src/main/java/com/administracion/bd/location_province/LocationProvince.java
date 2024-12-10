package com.administracion.bd.location_province;

import com.administracion.bd.location_country.LocationCountry;
import jakarta.persistence.*;

@Entity
@Table(name = "LOCATION_PROVINCE")
public class LocationProvince {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_PROVINCE_ID", nullable = false)
    private Long locationProvinceId;

    @Column(name = "PROVINCE_NAME", length = 255, nullable = false)
    private String provinceName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "LOCATION_COUNTRY_ID",
        referencedColumnName = "LOCATION_COUNTRY_ID",
        foreignKey = @ForeignKey(name = "FK_PROVINCE_COUNTRY")
    )
    private LocationCountry locationCountry;

    
    public Long getLocationProvinceId() {
        return locationProvinceId;
    }

    public void setLocationProvinceId(Long locationProvinceId) {
        this.locationProvinceId = locationProvinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public LocationCountry getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(LocationCountry locationCountry) {
        this.locationCountry = locationCountry;
    }
}
