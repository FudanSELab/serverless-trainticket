package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

/**
 * @author fdse
 */
public interface SecurityService {

    mResponse check(String accountId);

}
