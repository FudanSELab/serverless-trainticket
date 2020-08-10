package com.openfaas.function.repository;
import com.openfaas.function.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @author fdse
 */
public interface OrderRepository {

    ArrayList<Order> findByTravelDateAndTrainNumber(Date travelDate, String trainNumber);

}
