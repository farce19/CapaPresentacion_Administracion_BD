package com.administracion.bd.location;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(Long locationId) {
        return locationRepository.findById(locationId).orElseThrow(() -> new RuntimeException("Location not found"));
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Transactional
    public Location updateLocation(Long locationId, Location locationDetails) {
        Location existingLocation = getLocationById(locationId);
        existingLocation.setLocationCountryId(locationDetails.getLocationCountryId());
        existingLocation.setLocationProvinceId(locationDetails.getLocationProvinceId());
        existingLocation.setLocationCantonId(locationDetails.getLocationCantonId());
        existingLocation.setLocationDistrictId(locationDetails.getLocationDistrictId());
        existingLocation.setOtherDetails(locationDetails.getOtherDetails());
        return locationRepository.save(existingLocation);
    }

    @Transactional
    public void deleteLocation(Long locationId) {
        if (!locationRepository.existsById(locationId)) {
            throw new RuntimeException("Location not found");
        }
        locationRepository.deleteById(locationId);
    }
}
