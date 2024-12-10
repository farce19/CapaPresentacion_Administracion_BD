package com.administracion.bd.provider_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceService {

    @Autowired
    private ProviderServiceRepository providerServiceRepository;

    public List<ProviderService> getAllProviderServices() {
        return providerServiceRepository.findAll();
    }

    public ProviderService getProviderServiceById(Long id) {
        return providerServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProviderService not found with ID: " + id));
    }

    public ProviderService createProviderService(ProviderService providerService) {
        if (providerService.getProviderId() == null || providerService.getServiceId() == null) {
            throw new RuntimeException("Provider ID and Service ID cannot be null.");
        }
        return providerServiceRepository.save(providerService);
    }

    public ProviderService updateProviderService(Long id, ProviderService providerServiceDetails) {
        ProviderService existingProviderService = providerServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProviderService not found with ID: " + id));

        existingProviderService.setProviderId(providerServiceDetails.getProviderId());
        existingProviderService.setServiceId(providerServiceDetails.getServiceId());

        return providerServiceRepository.save(existingProviderService);
    }

    public void deleteProviderService(Long id) {
        if (!providerServiceRepository.existsById(id)) {
            throw new RuntimeException("ProviderService with ID " + id + " does not exist.");
        }
        providerServiceRepository.deleteById(id);
    }
}
