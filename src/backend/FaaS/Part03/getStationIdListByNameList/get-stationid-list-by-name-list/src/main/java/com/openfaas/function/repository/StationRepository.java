package com.openfaas.function.repository;

import com.openfaas.function.entity.Station;

public interface StationRepository  {

    Station findById(String id);

}
