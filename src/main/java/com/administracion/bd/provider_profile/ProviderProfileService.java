package com.administracion.bd.provider_profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderProfileService {

    @Autowired
    private ProviderProfileRepository providerProfileRepository;

    public List<ProviderProfile> getAllProfiles() {
        return providerProfileRepository.findAll();
    }

    public ProviderProfile getProfileById(Long id) {
        return providerProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProviderProfile not found with ID: " + id));
    }

    public ProviderProfile createProfile(ProviderProfile providerProfile) {
        if (providerProfile.getUserId() == null || providerProfile.getContactId() == null) {
            throw new RuntimeException("User ID and Contact ID cannot be null.");
        }
        return providerProfileRepository.save(providerProfile);
    }

    public ProviderProfile updateProfile(Long id, ProviderProfile profileDetails) {
        if (!providerProfileRepository.existsById(id)) {
            throw new RuntimeException("ProviderProfile not found with ID: " + id);
        }

        ProviderProfile existingProfile = providerProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProviderProfile not found with ID: " + id));

        existingProfile.setUserId(profileDetails.getUserId());
        existingProfile.setDescription(profileDetails.getDescription());
        existingProfile.setPricing(profileDetails.getPricing());
        existingProfile.setExperience(profileDetails.getExperience());
        existingProfile.setContactId(profileDetails.getContactId());

        return providerProfileRepository.save(existingProfile);
    }

    public void deleteProfile(Long id) {
        if (!providerProfileRepository.existsById(id)) {
            throw new RuntimeException("ProviderProfile with ID " + id + " does not exist.");
        }
        providerProfileRepository.deleteById(id);
    }
}
