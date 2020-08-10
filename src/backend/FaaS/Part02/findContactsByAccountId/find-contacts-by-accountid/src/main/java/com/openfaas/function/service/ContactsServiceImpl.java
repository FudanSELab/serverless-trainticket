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

public class ContactsServiceImpl implements ContactsService {

    private ContactsRepository contactsRepository=new ContactsRepositoryImpl();

    String success = "Success";

//    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsServiceImpl.class);

    @Override
    public mResponse findContactsByAccountId(UUID accountId) {
        ArrayList<Contacts> arr = contactsRepository.findByAccountId(accountId);
//        ContactsServiceImpl.LOGGER.info("[Contacts-Query-Service][Query-Contacts] Result Size: {}", arr.size());
        return new mResponse<>(1, success, arr);
    }


}


