package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;

/**
 * @author fdse
 */
public interface CancelService {
    /**
     * calculate refund by login id
     *
     * @param orderId order id
     * @return Response
     */
    mResponse calculateRefund(String orderId);

}
