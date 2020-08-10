package com.openfaas.function.repository;

//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.stereotype.Repository;
import com.openfaas.function.entity.Contacts;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author fdse
 */
//@Repository
public interface ContactsRepository {

    /**
     * find by account id
     *
     * @param accountId account id
     * @return ArrayList<Contacts>
     */
//    @Query("{ 'accountId' : ?0 }")
    ArrayList<Contacts> findByAccountId(UUID accountId);


}
