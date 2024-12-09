package com.administracion.bd.location_country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationCountryRepository extends JpaRepository<LocationCountry, Long> {
}
