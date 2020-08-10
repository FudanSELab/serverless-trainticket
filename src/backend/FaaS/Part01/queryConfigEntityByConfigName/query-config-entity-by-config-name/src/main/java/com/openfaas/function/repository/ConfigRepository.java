package com.openfaas.function.repository;

import com.openfaas.function.entity.Config;

import java.util.List;

/**
 * @author fdse
 */
public interface ConfigRepository {

    /**
     * find by name
     *
     * @param name name
     * @return Config
     */
    Config findByName(String name);

}
