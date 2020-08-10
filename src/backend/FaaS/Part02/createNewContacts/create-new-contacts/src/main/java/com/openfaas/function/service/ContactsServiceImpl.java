package com.openfaas.function.service;

import com.openfaas.function.entity.*;
import com.openfaas.function.repository.ContactsRepositoryImpl;
import edu.fudan.common.util.mResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Service;
import com.openfaas.function.repository.ContactsRepository;

import java.util.ArrayList;
import java.util.UUID;


/**
 * @author fdse
 */
//@Service
//@Slf4j
public class ContactsServiceImpl implements ContactsService {

    private ContactsRepository contactsRepository = new ContactsRepositoryImpl();

    String success = "Success";

//    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsServiceImpl.class);

    @Override
    public mResponse create(Contacts addContacts) {
        Contacts contacts = new Contacts();
        contacts.setId(UUID.randomUUID());
        contacts.setName(addContacts.getName());
        contacts.setPhoneNumber(addContacts.getPhoneNumber());
        contacts.setDocumentNumber(addContacts.getDocumentNumber());
        contacts.setAccountId(addContacts.getAccountId());
        contacts.setDocumentType(addContacts.getDocumentType());

        ArrayList<Contacts> accountContacts = contactsRepository.findByAccountId(addContacts.getAccountId());

        if (accountContacts.contains(contacts)) {
//            ContactsServiceImpl.LOGGER.info("[Contacts-Add&Delete-Service][AddContacts] Fail.Contacts already exists");
            return new mResponse<>(0, "Contacts already exists", null);
        } else {
            contactsRepository.save(contacts);
//            ContactsServiceImpl.LOGGER.info("[Contacts-Add&Delete-Service][AddContacts] Success.");
            return new mResponse<>(1, "Create contacts success", contacts);
        }
    }

}


