package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

/**
 * @author fdse
 */
public interface OrderService {

    mResponse getSoldTickets(Seat seatRequest);

}
