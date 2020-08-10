package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

import java.util.ArrayList;

/**
 * @author fdse
 */
public interface OrderService {

    mResponse<ArrayList<Order>> queryOrders(OrderInfo qi, String accountId);

    mResponse queryOrdersForRefresh(OrderInfo qi, String accountId);

}
