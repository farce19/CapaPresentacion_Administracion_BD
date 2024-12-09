package com.administracion.bd.location_country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationCountryService {

    @Autowired
    private LocationCountryRepository locationCountryRepository;

    public List<LocationCountry> getAllCountries() {
        return locationCountryRepository.findAll();
    }

    public LocationCountry getCountryById(Long id) {
        return locationCountryRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Country not found with ID: " + id));
    }

    public LocationCountry createCountry(LocationCountry locationCountry) {
        return locationCountryRepository.save(locationCountry);
    }

    public LocationCountry updateCountry(Long id, LocationCountry locationCountryDetails) {
        LocationCountry existingCountry = locationCountryRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Country not found with ID: " + id));

        existingCountry.setCountryName(locationCountryDetails.getCountryName());
        return locationCountryRepository.save(existingCountry);
    }

    public void deleteCountry(Long id) {
        if (locationCountryRepository.existsById(id)) {
            locationCountryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Country with ID " + id + " does not exist.");
        }
    }
}
