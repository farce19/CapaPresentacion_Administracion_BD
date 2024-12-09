package com.administracion.bd.provider_service;

import jakarta.persistence.*;

@Entity
@Table(name = "provider_service")
public class ProviderService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_service_id")
    private Long providerServiceId;

    @Column(name = "provider_id", nullable = false)
    private Long providerId;

    @Column(name = "service_id", nullable = false)
    private Long serviceId;

    // Getters y Setters
    public Long getProviderServiceId() {
        return providerServiceId;
    }

    public void setProviderServiceId(Long providerServiceId) {
        this.providerServiceId = providerServiceId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}
