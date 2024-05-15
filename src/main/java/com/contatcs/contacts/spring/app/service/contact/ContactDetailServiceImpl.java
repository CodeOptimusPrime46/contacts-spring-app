package com.contatcs.contacts.spring.app.service.contact;


import com.contatcs.contacts.spring.app.model.ContactDetail;
import com.contatcs.contacts.spring.app.repository.ContactRepository;
import com.contatcs.contacts.spring.app.response.ContactResponse;
import com.contatcs.contacts.spring.app.service.auth.AuthService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ContactDetailServiceImpl implements ContactDetailService {

    private final ContactRepository contactRepository;

//    private final AuthService authService;

//    private final ObjectMapper mapper;

    @Autowired
    public ContactDetailServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactResponse createContact(ContactDetail contactDetail) {
        contactRepository.save(contactDetail);
        return new ContactResponse("Contact Created", HttpStatus.CREATED);
    }

    @Override
    public ContactResponse getContactDetailsById(int id) {
        Optional<ContactDetail> contactDetail = contactRepository.findById(id);

        if (contactDetail.isEmpty()) {
            String message = "Contact with id " + id + " not found";
            return new ContactResponse(message, HttpStatus.NO_CONTENT);
        }
        ContactDetail contact = contactDetail.get();
        return new ContactResponse(contact, HttpStatus.OK);
    }

    @Override
    public ContactResponse getAllContactDetails() {
        List<ContactDetail> contactDetailList = contactRepository.findAll();

        Object message = contactDetailList;
        HttpStatus httpStatus = HttpStatus.OK;

        if (contactDetailList.isEmpty()) {
            message = "No contacts found";
            httpStatus = HttpStatus.NO_CONTENT;
            return new ContactResponse(message, httpStatus);
        }

        return new ContactResponse(message, httpStatus);
    }

    @Override
    public ContactResponse updateContactDetailsById(ContactDetail updateRequest, int contactId) {
        Optional<ContactDetail> contactDetailOpt = contactRepository.findById(contactId);
        updateRequest.setId(contactId);
        contactRepository.save(updateRequest);
        if (contactDetailOpt.isEmpty()) {
            return new ContactResponse("Contact Created", HttpStatus.CREATED);
        }
        return new ContactResponse("Contact Updated", HttpStatus.OK);
    }

    @Override
    public ContactResponse deleteContactDetailsById(int contactId) {
        Optional<ContactDetail> contactDetail = contactRepository.findById(contactId);

        if (contactDetail.isEmpty()) {
            String message = "Contact with id " + contactId + " not found";
            return new ContactResponse(message, HttpStatus.NO_CONTENT);
        }

        contactRepository.deleteById(contactId);
        return new ContactResponse("Contact Deleted", HttpStatus.OK);
    }

    @Override
    public ContactResponse deleteAllContactDetails() {

        if (0 == contactRepository.count()) {
            return new ContactResponse("No contacts present", HttpStatus.NOT_FOUND);
        }
        contactRepository.deleteAll();
        return new ContactResponse("All Contacts Deleted", HttpStatus.OK);
    }

}
