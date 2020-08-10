package com.openfaas.function.repository;

//import org.springframework.data.repository.CrudRepository;
import com.openfaas.function.entity.Trip;
import com.openfaas.function.entity.TripId;

import java.util.ArrayList;

/**
 * @author fdse
 */
public interface TripRepository  {

    Trip findByTripId(TripId tripId);

}
