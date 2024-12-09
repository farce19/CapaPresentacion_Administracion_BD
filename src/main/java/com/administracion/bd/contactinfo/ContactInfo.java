package com.administracion.bd.contactinfo;

import jakarta.persistence.*;

@Entity
@Table(name = "CONTACT_INFO")
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_ID", nullable = false)
    private Long contactId;

    @Column(name = "PHONE_NUMBER", length = 255)
    private String phoneNumber;

    @Column(name = "SECONDARY_PHONE_NUMBER", length = 255)
    private String secondaryPhoneNumber;

    
    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSecondaryPhoneNumber() {
        return secondaryPhoneNumber;
    }

    public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
        this.secondaryPhoneNumber = secondaryPhoneNumber;
    }
}
