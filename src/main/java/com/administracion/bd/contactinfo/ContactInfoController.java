package com.administracion.bd.contactinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-info")
public class ContactInfoController {

    @Autowired
    private ContactInfoService contactInfoService;

    @GetMapping
    public List<ContactInfo> getAllContacts() {
        return contactInfoService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactInfo> getContactById(@PathVariable Long id) {
        ContactInfo contactInfo = contactInfoService.getContactById(id);
        if (contactInfo != null) {
            return ResponseEntity.ok(contactInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ContactInfo createContact(@RequestBody ContactInfo contactInfo) {
        return contactInfoService.saveContact(contactInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactInfo> updateContact(@PathVariable Long id, @RequestBody ContactInfo updatedContact) {
        ContactInfo existingContact = contactInfoService.getContactById(id);
        if (existingContact != null) {
            existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
            existingContact.setSecondaryPhoneNumber(updatedContact.getSecondaryPhoneNumber());
            return ResponseEntity.ok(contactInfoService.saveContact(existingContact));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        try {
            contactInfoService.deleteContact(id);
            return ResponseEntity.ok("Contact deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }
}
