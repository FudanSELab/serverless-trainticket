package com.openfaas.function.repository;

import com.openfaas.function.entity.Money;

import java.util.List;

/**
 * @author fdse
 */
public interface AddMoneyRepository {

    /**
     * find by user id
     *
     * @param userId user id
     * @return List<Money>
     */
    List<Money> findByUserId(String userId);

    void save(Money money);
}
