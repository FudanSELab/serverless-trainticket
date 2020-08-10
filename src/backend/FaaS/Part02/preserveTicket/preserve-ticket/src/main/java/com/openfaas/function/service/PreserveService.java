package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.OrderTicketsInfo;

/**
 * @author fdse
 */
public interface PreserveService {

    mResponse preserve(OrderTicketsInfo oti);
}
