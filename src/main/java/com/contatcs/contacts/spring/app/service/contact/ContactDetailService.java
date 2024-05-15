package com.contatcs.contacts.spring.app.service.contact;

import com.contatcs.contacts.spring.app.model.ContactDetail;
import com.contatcs.contacts.spring.app.response.ContactResponse;

public interface ContactDetailService {

    ContactResponse createContact(ContactDetail request);

    ContactResponse getContactDetailsById(int id);

    ContactResponse getAllContactDetails();

    ContactResponse updateContactDetailsById(ContactDetail request, int contactId);

    ContactResponse deleteContactDetailsById(int contactId);

    ContactResponse deleteAllContactDetails();
}
