package com.administracion.bd.location_district;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationDistrictService {

    @Autowired
    private LocationDistrictRepository locationDistrictRepository;

    public List<LocationDistrict> getAllDistricts() {
        return locationDistrictRepository.findAll();
    }

    public LocationDistrict saveDistrict(LocationDistrict district) {
        return locationDistrictRepository.save(district);
    }

    public LocationDistrict updateDistrict(Long id, LocationDistrict updatedDistrict) {
        Optional<LocationDistrict> existingDistrictOpt = locationDistrictRepository.findById(id);
        if (existingDistrictOpt.isPresent()) {
            LocationDistrict existingDistrict = existingDistrictOpt.get();
            existingDistrict.setDistrictName(updatedDistrict.getDistrictName());
            existingDistrict.setLocationCanton(updatedDistrict.getLocationCanton());
            return locationDistrictRepository.save(existingDistrict);
        }
        return null;
    }

    public void deleteDistrict(Long id) {
        locationDistrictRepository.deleteById(id);
    }
}
