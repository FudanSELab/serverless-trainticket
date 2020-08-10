package com.openfaas.function.service;

import com.openfaas.function.entity.Payment;
import edu.fudan.common.util.mResponse;

/**
 * @author Chenjie
 * @date 2017/4/3
 */
public interface PaymentService {

    mResponse pay(Payment info);


}
