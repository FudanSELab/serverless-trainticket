package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.dto.UserDto;

import java.util.UUID;

/**
 * @author fdse
 */
public interface UserService {

    mResponse findByUserId(String userId);

}
