package com.openfaas.function.service;

import com.openfaas.function.entity.*;
import com.openfaas.function.repository.PaymentRepository;
import com.openfaas.function.repository.PaymentRepositoryImpl;
import edu.fudan.common.util.mResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @date 2017/6/23.
 */
//@Service
public class PaymentServiceImpl implements PaymentService {


    PaymentRepository paymentRepository = new PaymentRepositoryImpl();


//    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Override
    public mResponse pay(Payment info) {

        if (paymentRepository.findByOrderId(info.getOrderId()) == null) {
            Payment payment = new Payment();
            payment.setOrderId(info.getOrderId());
            payment.setPrice(info.getPrice());
            payment.setUserId(info.getUserId());
            paymentRepository.save(payment);
            return new mResponse<>(1, "Pay Success", null);
        } else {
            return new mResponse<>(0, "Pay Failed, order not found with order id" + info.getOrderId(), null);
        }
    }

}
