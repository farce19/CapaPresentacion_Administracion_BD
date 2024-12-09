package com.administracion.bd.location_canton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationCantonService {

    @Autowired
    private LocationCantonRepository locationCantonRepository;

    public List<LocationCanton> getAllLocationCantons() {
        return locationCantonRepository.findAll();
    }

    public LocationCanton getLocationCantonById(Long id) {
        return locationCantonRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Location Canton with ID " + id + " not found."));
    }

    public LocationCanton saveLocationCanton(LocationCanton locationCanton) {
        return locationCantonRepository.save(locationCanton);
    }

    public LocationCanton updateLocationCanton(Long id, LocationCanton locationCantonDetails) {
        LocationCanton existingCanton = locationCantonRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Location Canton with ID " + id + " not found."));
        existingCanton.setCantonName(locationCantonDetails.getCantonName());
        existingCanton.setLocationProvinceId(locationCantonDetails.getLocationProvinceId());
        return locationCantonRepository.save(existingCanton);
    }

    public void deleteLocationCanton(Long id) {
        if (locationCantonRepository.existsById(id)) {
            locationCantonRepository.deleteById(id);
        } else {
            throw new RuntimeException("Location Canton with ID " + id + " does not exist.");
        }
    }
}
