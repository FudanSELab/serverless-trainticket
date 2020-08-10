package com.openfaas.function.service;

import com.openfaas.function.dto.BasicAuthDto;
import edu.fudan.common.util.mResponse;

/**
 * @author fdse
 */
public interface TokenService {

    /**
     * get token by dto
     *
     * @param dto dto
     * @return Response
     */
    mResponse getToken(BasicAuthDto dto);


}
