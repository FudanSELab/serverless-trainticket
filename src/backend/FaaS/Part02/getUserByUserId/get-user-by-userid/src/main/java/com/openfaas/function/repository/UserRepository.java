package com.openfaas.function.repository;

//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
import com.openfaas.function.entity.User;

import java.util.UUID;

/**
 * @author fdse
 */
//@Repository
public interface UserRepository {

    User findByUserId(UUID userId);

}
