package com.openfaas.function.service;

import com.openfaas.function.repository.OrderRepositoryImpl;
import edu.fudan.common.util.mResponse;
//import lombok.extern.slf4j.Slf4j;
import com.openfaas.function.entity.*;
import com.openfaas.function.repository.OrderRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author fdse
 */

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository=new OrderRepositoryImpl();

//    private static final Logger LoggerGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    String success = "Success";
    String orderNotFound = "Order Not Found";



    @Override
    public mResponse saveChanges(Order order) {

        Order oldOrder = orderRepository.findById(order.getId());
        if (oldOrder == null) {
            return new mResponse<>(0, orderNotFound, null);
        } else {
            oldOrder.setAccountId(order.getAccountId());
            oldOrder.setBoughtDate(order.getBoughtDate());
            oldOrder.setTravelDate(order.getTravelDate());
            oldOrder.setTravelTime(order.getTravelTime());
            oldOrder.setCoachNumber(order.getCoachNumber());
            oldOrder.setSeatClass(order.getSeatClass());
            oldOrder.setSeatNumber(order.getSeatNumber());
            oldOrder.setFrom(order.getFrom());
            oldOrder.setTo(order.getTo());
            oldOrder.setStatus(order.getStatus());
            oldOrder.setTrainNumber(order.getTrainNumber());
            oldOrder.setPrice(order.getPrice());
            oldOrder.setContactsName(order.getContactsName());
            oldOrder.setContactsDocumentNumber(order.getContactsDocumentNumber());
            oldOrder.setDocumentType(order.getDocumentType());
            orderRepository.deleteById(order.getId());
            orderRepository.save(oldOrder);
//            OrderServiceImpl.LOGGER.info("[Order Service] Success.");
            return new mResponse<>(1, success, oldOrder);
        }
    }

}

