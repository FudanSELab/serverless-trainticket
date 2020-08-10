package com.openfaas.function.service;

import com.openfaas.function.entity.*;
import edu.fudan.common.util.mResponse;
import java.util.UUID;

/**
 * @author fdse
 */
public interface ContactsService {

    /**
     * find contacts by id
     *
     * @param id id
     * @return Reaponse
     */
    mResponse findContactsById(UUID id);

}
