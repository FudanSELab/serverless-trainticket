package com.openfaas.function.repository;

import com.openfaas.function.entity.Payment;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author fdse
 */
public interface PaymentRepository {

    /**
     * find by user id
     *
     * @param userId user id
     * @return List<Payment>
     */
    List<Payment> findByUserId(String userId);

    void save(Payment payment);

}
