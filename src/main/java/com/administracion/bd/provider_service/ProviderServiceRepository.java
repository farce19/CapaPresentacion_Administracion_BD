package com.administracion.bd.provider_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderServiceRepository extends JpaRepository<ProviderService, Long> {
}
