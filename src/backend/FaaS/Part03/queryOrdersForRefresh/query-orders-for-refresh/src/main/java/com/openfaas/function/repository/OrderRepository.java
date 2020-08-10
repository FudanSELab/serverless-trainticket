package com.openfaas.function.repository;

import com.openfaas.function.entity.Order;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @author fdse
 */
public interface OrderRepository{

    ArrayList<Order> findByAccountId(UUID accountId);

}
