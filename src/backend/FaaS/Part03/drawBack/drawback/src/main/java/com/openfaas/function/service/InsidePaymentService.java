package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;


/**
 * @author Administrator
 * @date 2017/6/20.
 */
public interface InsidePaymentService {


    /**
     * drawback with user id, money
     *
     * @param userId user id
     * @param  money money
     * @return Response
     */
    mResponse drawBack(String userId, String money);

}
