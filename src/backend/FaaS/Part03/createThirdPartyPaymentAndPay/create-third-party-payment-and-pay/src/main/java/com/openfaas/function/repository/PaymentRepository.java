package com.openfaas.function.repository;

import com.openfaas.function.entity.Payment;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author fdse
 */
public interface PaymentRepository {

    Payment findByOrderId(String orderId);

    void save(Payment payment);
}
