package com.openfaas.function.service;

import com.openfaas.function.entity.Config;
import com.openfaas.function.repository.ConfigRepository;
import com.openfaas.function.repository.ConfigRepositoryImpl;
import edu.fudan.common.util.mResponse;

/**
 * @author fdse
 */
public class ConfigServiceImpl implements ConfigService {

    ConfigRepository repository=new ConfigRepositoryImpl();

    @Override
    public mResponse query(String name) {
        Config config = repository.findByName(name);
        if (config == null) {
            return new mResponse<>(0, "No content", null);
        } else {
            return new mResponse<>(1, "Success", config);
        }
    }

}
