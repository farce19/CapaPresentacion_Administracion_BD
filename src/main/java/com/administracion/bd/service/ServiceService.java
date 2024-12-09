package com.administracion.bd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    public ServiceEntity getServiceById(Long id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + id));
    }

    public ServiceEntity createService(ServiceEntity service) {
        if (service.getCategoryId() == null) {
            throw new RuntimeException("Category ID cannot be null.");
        }
        return serviceRepository.save(service);
    }

    public ServiceEntity updateService(Long id, ServiceEntity serviceDetails) {
        ServiceEntity existingService = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + id));

        existingService.setServiceName(serviceDetails.getServiceName());
        existingService.setServiceDescription(serviceDetails.getServiceDescription());
        existingService.setCategoryId(serviceDetails.getCategoryId());

        return serviceRepository.save(existingService);
    }

    public void deleteService(Long id) {
        if (!serviceRepository.existsById(id)) {
            throw new RuntimeException("Service with ID " + id + " does not exist.");
        }
        serviceRepository.deleteById(id);
    }
}
