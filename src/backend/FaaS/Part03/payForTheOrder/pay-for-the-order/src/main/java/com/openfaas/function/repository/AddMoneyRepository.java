package com.openfaas.function.repository;

import com.openfaas.function.entity.Money;
import com.openfaas.function.entity.Payment;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author fdse
 */
public interface AddMoneyRepository  {

    /**
     * find by user id
     *
     * @param userId user id
     * @return List<Money>
     */
    List<Money> findByUserId(String userId);

}
