package com.administracion.bd.location_district;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class LocationDistrictController {

    @Autowired
    private LocationDistrictService locationDistrictService;

    @GetMapping
    public List<LocationDistrict> getAllDistricts() {
        return locationDistrictService.getAllDistricts();
    }

    @PostMapping
    public LocationDistrict createDistrict(@RequestBody LocationDistrict district) {
        return locationDistrictService.saveDistrict(district);
    }

    @PutMapping("/{id}")
    public LocationDistrict updateDistrict(@PathVariable Long id, @RequestBody LocationDistrict district) {
        return locationDistrictService.updateDistrict(id, district);
    }

    @DeleteMapping("/{id}")
    public void deleteDistrict(@PathVariable Long id) {
        locationDistrictService.deleteDistrict(id);
    }
}
