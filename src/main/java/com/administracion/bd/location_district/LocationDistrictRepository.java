package com.administracion.bd.location_district;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDistrictRepository extends JpaRepository<LocationDistrict, Long> {
}
