package com.administracion.bd.booking;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKING_ID", nullable = false)
    private Long bookingId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "PROVIDER_ID")
    private Long providerId;

    @Column(name = "SERVICE_ID")
    private Long serviceId;

    @Column(name = "BOOKING_DATE")
    @Temporal(TemporalType.DATE)
    private Date bookingDate;

    @Column(name = "STATUS_ID")
    private Long statusId;

    @Column(name = "RATING_ID")
    private Long ratingId;

    @Column(name = "OTHER_INSTRUCTIONS")
    private String otherInstructions;

    
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public String getOtherInstructions() {
        return otherInstructions;
    }

    public void setOtherInstructions(String otherInstructions) {
        this.otherInstructions = otherInstructions;
    }
}
