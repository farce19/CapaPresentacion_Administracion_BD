package com.administracion.bd.location_canton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location-canton")
public class LocationCantonController {

    @Autowired
    private LocationCantonService locationCantonService;

    @GetMapping
    public List<LocationCanton> getAllLocationCantons() {
        return locationCantonService.getAllLocationCantons();
    }

    @GetMapping("/{id}")
    public LocationCanton getLocationCantonById(@PathVariable Long id) {
        return locationCantonService.getLocationCantonById(id);
    }

    @PostMapping
    public LocationCanton createLocationCanton(@RequestBody LocationCanton locationCanton) {
        return locationCantonService.saveLocationCanton(locationCanton);
    }

    @PutMapping("/{id}")
    public LocationCanton updateLocationCanton(@PathVariable Long id, @RequestBody LocationCanton locationCanton) {
        return locationCantonService.updateLocationCanton(id, locationCanton);
    }

    @DeleteMapping("/{id}")
    public void deleteLocationCanton(@PathVariable Long id) {
        locationCantonService.deleteLocationCanton(id);
    }
}
