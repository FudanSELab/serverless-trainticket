package com.openfaas.function.service;

import com.openfaas.function.repository.OrderRepositoryImpl;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;
import com.openfaas.function.repository.OrderRepository;


import java.util.*;

/**
 * @author fdse
 */

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository = new OrderRepositoryImpl();


    String success = "Success";
    String orderNotFound = "Order Not Found";


    @Override
    public mResponse create(Order order) {
        ArrayList<Order> accountOrders = orderRepository.findByAccountId(order.getAccountId());
        if (accountOrders.contains(order)) {
            //OrderServiceImpl.LOGGER.info("[Order Service][Order Create] Fail.Order already exists.");
            return new mResponse<>(0, "Order already exist", null);
        } else {
            order.setId(UUID.randomUUID());
            orderRepository.save(order);
            //OrderServiceImpl.LOGGER.info("[Order Service][Order Create] Success.");
            //OrderServiceImpl.LOGGER.info("[Order Service][Order Create] Price: {}", order.getPrice());
            return new mResponse<>(1, success, order);
        }
    }

}

