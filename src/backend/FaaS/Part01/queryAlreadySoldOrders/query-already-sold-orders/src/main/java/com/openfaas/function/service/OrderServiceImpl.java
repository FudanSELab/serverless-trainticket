package com.openfaas.function.service;

import com.openfaas.function.repository.OrderRepository;
import com.openfaas.function.repository.OrderRepositoryImpl;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

import java.util.*;

/**
 * @author fdse
 */

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository=new OrderRepositoryImpl();


    String success = "Success";
    String orderNotFound = "Order Not Found";


    @Override
    public mResponse queryAlreadySoldOrders(Date travelDate, String trainNumber) {
        ArrayList<Order> orders = orderRepository.findByTravelDateAndTrainNumber(travelDate, trainNumber);
        SoldTicket cstr = new SoldTicket();
        cstr.setTravelDate(travelDate);
        cstr.setTrainNumber(trainNumber);
        for (Order order : orders) {
            if (order.getStatus() >= OrderStatus.CHANGE.getCode()) {
                continue;
            }
            if (order.getSeatClass() == SeatClass.NONE.getCode()) {
                cstr.setNoSeat(cstr.getNoSeat() + 1);
            } else if (order.getSeatClass() == SeatClass.BUSINESS.getCode()) {
                cstr.setBusinessSeat(cstr.getBusinessSeat() + 1);
            } else if (order.getSeatClass() == SeatClass.FIRSTCLASS.getCode()) {
                cstr.setFirstClassSeat(cstr.getFirstClassSeat() + 1);
            } else if (order.getSeatClass() == SeatClass.SECONDCLASS.getCode()) {
                cstr.setSecondClassSeat(cstr.getSecondClassSeat() + 1);
            } else if (order.getSeatClass() == SeatClass.HARDSEAT.getCode()) {
                cstr.setHardSeat(cstr.getHardSeat() + 1);
            } else if (order.getSeatClass() == SeatClass.SOFTSEAT.getCode()) {
                cstr.setSoftSeat(cstr.getSoftSeat() + 1);
            } else if (order.getSeatClass() == SeatClass.HARDBED.getCode()) {
                cstr.setHardBed(cstr.getHardBed() + 1);
            } else if (order.getSeatClass() == SeatClass.SOFTBED.getCode()) {
                cstr.setSoftBed(cstr.getSoftBed() + 1);
            } else if (order.getSeatClass() == SeatClass.HIGHSOFTBED.getCode()) {
                cstr.setHighSoftBed(cstr.getHighSoftBed() + 1);
            } else {
                //OrderServiceImpl.LOGGER.info("[Order Service][Calculate Sold Tickets] Seat class not exists. Order ID: {}", order.getId());
            }
        }
        return new mResponse<>(1, success, cstr);
    }


}

