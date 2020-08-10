package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;

/**
 * @author fdse
 */
public interface CancelService {

    /**
     * cancel order by order id, login id
     *
     * @param orderId order id
     * @param loginId login id
     * @throws  Exception
     * @return Response
     */
    mResponse cancelOrder(String orderId, String loginId);

}
