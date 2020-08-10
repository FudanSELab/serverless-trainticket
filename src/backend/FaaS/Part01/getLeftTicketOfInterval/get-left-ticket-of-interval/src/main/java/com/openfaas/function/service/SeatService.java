package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.Seat;

/**
 * @author fdse
 */
public interface SeatService {
    mResponse getLeftTicketOfInterval(Seat seatRequest);
}
