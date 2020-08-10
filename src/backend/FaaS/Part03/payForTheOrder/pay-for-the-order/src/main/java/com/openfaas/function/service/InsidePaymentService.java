package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;


/**
 * @author Administrator
 * @date 2017/6/20.
 */
public interface InsidePaymentService {

    /**
     * pay by payment info
     *
     * @param info payment info
     * @return Response
     */
    mResponse pay(PaymentInfo info );


}
