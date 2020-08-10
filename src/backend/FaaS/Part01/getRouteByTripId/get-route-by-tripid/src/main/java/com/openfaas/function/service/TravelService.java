package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

import java.util.ArrayList;

/**
 * @author  Chenjie Xu
 * @date 2017/5/9.
 */
public interface TravelService {


    mResponse getRouteByTripId(String tripId);


}
