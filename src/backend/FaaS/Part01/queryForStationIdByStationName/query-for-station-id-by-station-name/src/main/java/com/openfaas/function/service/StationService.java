package com.openfaas.function.service;

import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

import java.util.List;

public interface StationService {

    mResponse queryForId(String stationName);


}
