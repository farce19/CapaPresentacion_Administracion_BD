package com.administracion.bd.location_province;

import com.administracion.bd.location_country.LocationCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location-provinces")
public class LocationProvinceController {

    @Autowired
    private LocationProvinceService locationProvinceService;

    @Autowired
    private LocationCountryService locationCountryService;

    @GetMapping
    public List<LocationProvince> getAllProvinces() {
        return locationProvinceService.getAllProvinces();
    }

    @GetMapping("/{id}")
    public LocationProvince getProvinceById(@PathVariable Long id) {
        return locationProvinceService.getProvinceById(id);
    }

    @PostMapping
    public LocationProvince createProvince(@RequestBody LocationProvince locationProvince) {
        return locationProvinceService.createProvince(locationProvince);
    }

    @PutMapping("/{id}")
    public LocationProvince updateProvince(
        @PathVariable Long id, 
        @RequestBody LocationProvince locationProvinceDetails
    ) {
        return locationProvinceService.updateProvince(id, locationProvinceDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProvince(@PathVariable Long id) {
        locationProvinceService.deleteProvince(id);
    }

    @GetMapping("/countries")
    public List<?> getAllCountries() {
        return locationCountryService.getAllCountries();
    }
}
