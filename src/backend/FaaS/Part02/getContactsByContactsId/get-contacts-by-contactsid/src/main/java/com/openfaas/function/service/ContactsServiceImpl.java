package com.openfaas.function.service;

import com.openfaas.function.entity.*;
import com.openfaas.function.repository.ContactsRepositoryImpl;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.repository.ContactsRepository;

import java.util.ArrayList;
import java.util.UUID;


/**
 * @author fdse
 */

public class ContactsServiceImpl implements ContactsService {

    private ContactsRepository contactsRepository=new ContactsRepositoryImpl();

    String success = "Success";


    @Override
    public mResponse findContactsById(UUID id) {
        Contacts contacts = contactsRepository.findById(id);
        if (contacts != null) {
            return new mResponse<>(1, success, contacts);
        } else {
            return new mResponse<>(0, "No contacts accorrding to contacts id", id);
        }
    }

}


