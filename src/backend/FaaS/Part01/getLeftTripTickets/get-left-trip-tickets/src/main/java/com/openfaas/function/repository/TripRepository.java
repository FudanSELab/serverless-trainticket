package com.openfaas.function.repository;

import com.openfaas.function.entity.*;

import java.util.ArrayList;

/**
 * @author fdse
 */
public interface TripRepository {

    ArrayList<Trip> findAll();
}
