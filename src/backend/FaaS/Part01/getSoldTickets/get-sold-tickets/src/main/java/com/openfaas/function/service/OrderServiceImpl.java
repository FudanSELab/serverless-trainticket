package com.openfaas.function.service;

import com.openfaas.function.repository.OrderRepositoryImpl;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;
import com.openfaas.function.repository.OrderRepository;

import java.util.*;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository = new OrderRepositoryImpl();

    String success = "Success";
    String orderNotFound = "Order Not Found";

    @Override
    public mResponse getSoldTickets(Seat seatRequest) {

            ArrayList<Order> list = orderRepository.findByTravelDateAndTrainNumber(seatRequest.getTravelDate(),
                    seatRequest.getTrainNumber());
            if (list != null && !list.isEmpty()) {
                Set ticketSet = new HashSet();
                for (Order tempOrder : list) {
                    ticketSet.add(new Ticket(tempOrder.getSeatNumber(),
                            tempOrder.getFrom(), tempOrder.getTo()));
                }
                LeftTicketInfo leftTicketInfo = new LeftTicketInfo();
                leftTicketInfo.setSoldTickets(ticketSet);
                //OrderServiceImpl.LOGGER.info("Left ticket info is: {}", leftTicketInfo.toString());
                return new mResponse<>(1, success, leftTicketInfo);
            } else {
                //OrderServiceImpl.LOGGER.info("Left ticket info is empty");
                return new mResponse<>(0, "Order is Null.", null);
            }

    }

}

