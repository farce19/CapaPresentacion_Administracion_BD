package com.administracion.bd.location_province;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationProvinceService {

    @Autowired
    private LocationProvinceRepository locationProvinceRepository;

    public List<LocationProvince> getAllProvinces() {
        return locationProvinceRepository.findAll();
    }

    public LocationProvince getProvinceById(Long id) {
        return locationProvinceRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Province not found with ID: " + id));
    }

    public LocationProvince createProvince(LocationProvince locationProvince) {
        return locationProvinceRepository.save(locationProvince);
    }

    public LocationProvince updateProvince(Long id, LocationProvince locationProvinceDetails) {
        LocationProvince existingProvince = locationProvinceRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Province not found with ID: " + id));

        existingProvince.setProvinceName(locationProvinceDetails.getProvinceName());
        existingProvince.setLocationCountry(locationProvinceDetails.getLocationCountry());
        return locationProvinceRepository.save(existingProvince);
    }

    public void deleteProvince(Long id) {
        if (locationProvinceRepository.existsById(id)) {
            locationProvinceRepository.deleteById(id);
        } else {
            throw new RuntimeException("Province with ID " + id + " does not exist.");
        }
    }
}
