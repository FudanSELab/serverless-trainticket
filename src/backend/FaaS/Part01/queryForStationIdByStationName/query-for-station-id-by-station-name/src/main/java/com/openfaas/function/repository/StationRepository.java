package com.openfaas.function.repository;

import com.openfaas.function.entity.Station;

import java.util.List;


public interface StationRepository{

    Station findByName(String name);

}
