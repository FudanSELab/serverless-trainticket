package com.openfaas.function.repository;

import com.openfaas.function.entity.Order;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @author fdse
 */
//@Repository
public interface OrderRepository  {


    Order findById(UUID id);

    void deleteById(UUID id);

    void save(Order order);
}
