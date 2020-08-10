package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

/**
 * @author  Chenjie Xu
 * @date 2017/5/9.
 */
public interface TravelService {
    mResponse getTrainTypeByTripId(String tripId);
}
