package com.administracion.bd.location_country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location-country")
public class LocationCountryController {

    @Autowired
    private LocationCountryService locationCountryService;

    @GetMapping
    public List<LocationCountry> getAllCountries() {
        return locationCountryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public LocationCountry getCountryById(@PathVariable Long id) {
        return locationCountryService.getCountryById(id);
    }

    @PostMapping
    public LocationCountry createCountry(@RequestBody LocationCountry locationCountry) {
        return locationCountryService.createCountry(locationCountry);
    }

    @PutMapping("/{id}")
    public LocationCountry updateCountry(@PathVariable Long id, @RequestBody LocationCountry locationCountry) {
        return locationCountryService.updateCountry(id, locationCountry);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        locationCountryService.deleteCountry(id);
    }
}
