package com.contatcs.contacts.spring.app.repository;

import com.contatcs.contacts.spring.app.model.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactDetail, Integer>{

}
