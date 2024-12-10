package com.administracion.bd.provider_profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provider-profiles")
public class ProviderProfileController {

    @Autowired
    private ProviderProfileService providerProfileService;

    @GetMapping
    public List<ProviderProfile> getAllProfiles() {
        return providerProfileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public ProviderProfile getProfileById(@PathVariable Long id) {
        return providerProfileService.getProfileById(id);
    }

    @PostMapping
    public ProviderProfile createProfile(@RequestBody ProviderProfile providerProfile) {
        if (providerProfile.getUserId() == null || providerProfile.getContactId() == null) {
            throw new IllegalArgumentException("User ID and Contact ID cannot be null.");
        }
        return providerProfileService.createProfile(providerProfile);
    }

    @PutMapping("/{id}")
    public ProviderProfile updateProfile(@PathVariable Long id, @RequestBody ProviderProfile profileDetails) {
        if (profileDetails.getUserId() == null || profileDetails.getContactId() == null) {
            throw new IllegalArgumentException("User ID and Contact ID cannot be null.");
        }
        return providerProfileService.updateProfile(id, profileDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id) {
        providerProfileService.deleteProfile(id);
    }
}
