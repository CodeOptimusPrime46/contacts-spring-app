package com.contatcs.contacts.spring.app.controller;

import com.contatcs.contacts.spring.app.model.ContactDetail;
import com.contatcs.contacts.spring.app.response.ContactResponse;
import com.contatcs.contacts.spring.app.service.contact.ContactDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private ContactDetailService contactDetailService;

    @Autowired
    ContactController(ContactDetailService contactDetailService) {
        this.contactDetailService = contactDetailService;
    }

    @PostMapping("/create")
    public ContactResponse createContact(@RequestBody ContactDetail request) {
        return contactDetailService.createContact(request);
    }

    @GetMapping("/read/{contactId}")
    public ContactResponse getContactDetailsById(@PathVariable("contactId") int contactId) {
        return contactDetailService.getContactDetailsById(contactId);
    }

    @GetMapping("/read-all")
    public ContactResponse getAllContactDetails() {
        return contactDetailService.getAllContactDetails();
    }

    @PutMapping("/update/{contactId}")
    public ContactResponse updateContactDetailsById(@RequestBody ContactDetail request, @PathVariable("contactId") int contactId) {
        return contactDetailService.updateContactDetailsById(request, contactId);
    }

    @DeleteMapping("/delete/{contactId}")
    public ContactResponse deleteContactDetailsById(@PathVariable("contactId") int contactId){
        return contactDetailService.deleteContactDetailsById(contactId);
    }

    @DeleteMapping("/delete-all")
    public ContactResponse deleteAllContactDetails() {
        return contactDetailService.deleteAllContactDetails();
    }

}
