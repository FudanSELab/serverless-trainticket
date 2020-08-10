package com.openfaas.function.service;

import com.openfaas.function.entity.*;
import edu.fudan.common.util.mResponse;

import java.util.UUID;

/**
 * @author fdse
 */
public interface ContactsService {
    /**
     * find contacts by account id
     *
     * @param accountId account id
     * @return Reaponse
     */
    mResponse findContactsByAccountId(UUID accountId);

}
