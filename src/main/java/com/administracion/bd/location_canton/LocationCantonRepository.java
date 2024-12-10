package com.administracion.bd.location_canton;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationCantonRepository extends JpaRepository<LocationCanton, Long> {
}
