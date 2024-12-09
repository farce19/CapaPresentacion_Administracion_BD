package com.administracion.bd.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return (List<Booking>) bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(id).orElse(null);
        if (existingBooking != null) {
            existingBooking.setUserId(updatedBooking.getUserId());
            existingBooking.setProviderId(updatedBooking.getProviderId());
            existingBooking.setServiceId(updatedBooking.getServiceId());
            existingBooking.setBookingDate(updatedBooking.getBookingDate());
            existingBooking.setStatusId(updatedBooking.getStatusId());
            existingBooking.setRatingId(updatedBooking.getRatingId());
            existingBooking.setOtherInstructions(updatedBooking.getOtherInstructions());
            return bookingRepository.save(existingBooking);
        }
        return null;
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
