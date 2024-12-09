package com.administracion.bd.contactinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactInfoService {

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    public List<ContactInfo> getAllContacts() {
        return (List<ContactInfo>) contactInfoRepository.findAll();
    }

    public ContactInfo getContactById(Long id) {
        return contactInfoRepository.findById(id).orElse(null);
    }

    public ContactInfo saveContact(ContactInfo contactInfo) {
        return contactInfoRepository.save(contactInfo);
    }

    public void deleteContact(Long id) {
        try {
            contactInfoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete contact. It may have dependencies.", e);
        }
    }
}
