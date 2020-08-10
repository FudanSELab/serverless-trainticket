package com.openfaas.function.repository;

//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.stereotype.Repository;
import com.openfaas.function.entity.SecurityConfig;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author fdse
 */
//@Repository
public interface SecurityRepository{

    SecurityConfig findByName(String name);

}
