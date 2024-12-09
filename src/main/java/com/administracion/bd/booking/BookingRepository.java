package com.administracion.bd.booking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    
    List<Booking> findByUserId(Long userId);
}
