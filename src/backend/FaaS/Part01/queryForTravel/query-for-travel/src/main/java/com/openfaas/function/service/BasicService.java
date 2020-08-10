package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

/**
 * @author Chenjie
 * @date 2017/6/6.
 */
public interface BasicService {

    /**
     * query for travel with travel information
     *
     * @param info information
     * @return Response
     */
    mResponse queryForTravel(Travel info);


}
