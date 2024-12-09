package com.administracion.bd.provider_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provider-services")
public class ProviderServiceController {

    @Autowired
    private ProviderServiceService providerServiceService;

    @GetMapping
    public List<ProviderService> getAllProviderServices() {
        return providerServiceService.getAllProviderServices();
    }

    @GetMapping("/{id}")
    public ProviderService getProviderServiceById(@PathVariable Long id) {
        return providerServiceService.getProviderServiceById(id);
    }

    @PostMapping
    public ProviderService createProviderService(@RequestBody ProviderService providerService) {
        return providerServiceService.createProviderService(providerService);
    }

    @PutMapping("/{id}")
    public ProviderService updateProviderService(@PathVariable Long id, @RequestBody ProviderService providerServiceDetails) {
        return providerServiceService.updateProviderService(id, providerServiceDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProviderService(@PathVariable Long id) {
        providerServiceService.deleteProviderService(id);
    }
}
