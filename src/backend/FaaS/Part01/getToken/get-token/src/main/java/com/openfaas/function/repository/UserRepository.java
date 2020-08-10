package com.openfaas.function.repository;

import com.openfaas.function.entity.User;

import java.util.Optional;

/**
 * @author fdse
 */
public interface UserRepository  {

    /**
     * find by username
     *
     * @param username username
     * @return User
     */
    User findByUsername(String username);

    /**
     * find by username and password
     *
     * @param username username
     * @param password password
     * @return User
     */
    User findByUsernameAndPassword(String username,String password);
}
