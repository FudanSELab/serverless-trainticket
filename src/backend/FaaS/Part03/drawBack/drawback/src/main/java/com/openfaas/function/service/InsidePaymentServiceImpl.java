package com.openfaas.function.service;

import com.openfaas.function.repository.AddMoneyRepositoryImpl;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;
import com.openfaas.function.repository.AddMoneyRepository;


import java.math.BigDecimal;
import java.util.*;

/**
 * @author fdse
 */
//@Service
public class InsidePaymentServiceImpl implements InsidePaymentService {

    public AddMoneyRepository addMoneyRepository=new AddMoneyRepositoryImpl();

//    private static final Logger LOGGER = LoggerFactory.getLogger(InsidePaymentServiceImpl.class);


    @Override
    public mResponse drawBack(String userId, String money) {
        if (addMoneyRepository.findByUserId(userId) != null) {
            Money addMoney = new Money();
            addMoney.setUserId(userId);
            addMoney.setMoney(money);
            addMoney.setType(MoneyType.D);
            addMoneyRepository.save(addMoney);
            return new mResponse<>(1, "Draw Back Money Scuuess", null);
        } else {
            return new mResponse<>(0, "Draw Back Money Failed", null);
        }
    }
}
