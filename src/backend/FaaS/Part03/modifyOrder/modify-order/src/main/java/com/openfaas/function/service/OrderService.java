package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

import java.util.Date;
import java.util.UUID;

/**
 * @author fdse
 */
public interface OrderService {

    mResponse modifyOrder(String orderId, int status);

}
