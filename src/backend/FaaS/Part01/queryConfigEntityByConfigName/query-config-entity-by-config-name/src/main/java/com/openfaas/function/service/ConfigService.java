package com.openfaas.function.service;

import com.openfaas.function.entity.Config;
import edu.fudan.common.util.mResponse;


/**
 * @author fdse
 */
public interface ConfigService {

    /**
     * Config retrieve
     *
     * @param name name
     * @return Response
     */
    mResponse query(String name);

}
