package com.openfaas.function.service;

import com.openfaas.function.repository.UserRepositoryImpl;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.User;
import com.openfaas.function.repository.UserRepository;

import java.util.UUID;

/**
 * @author fdse
 */

public class UserServiceImpl implements UserService {
    private UserRepository userRepository=new UserRepositoryImpl();

    @Override
    public mResponse findByUserId(String userId) {

        User user = userRepository.findByUserId(UUID.fromString(userId));
        if (user != null) {
            return new mResponse<>(1, "Find User Success", user);
        }
        return new mResponse<>(0, "No User", null);
    }

}
