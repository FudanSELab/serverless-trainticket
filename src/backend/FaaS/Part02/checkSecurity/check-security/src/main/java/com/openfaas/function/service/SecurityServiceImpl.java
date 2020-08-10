package com.openfaas.function.service;

import com.openfaas.function.repository.SecurityRepositoryImpl;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;
import com.openfaas.function.repository.SecurityRepository;
import okhttp3.OkHttpClient;


import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @author fdse
 */
public class SecurityServiceImpl implements SecurityService {
    private OkHttpClient client = new OkHttpClient();
    String function21_URI = "gateway.openfaas:8080/function/check-security-about-order.openfaas-fn";
    private SecurityRepository securityRepository = new SecurityRepositoryImpl();

    String success = "Success";


    @Override
    public mResponse check(String accountId) {
        //1.获取自己过去一小时的订单数和总有效票数
        OrderSecurity orderResult = getSecurityOrderInfoFromOrder(new Date(), accountId);
        //OrderSecurity orderOtherResult = getSecurityOrderOtherInfoFromOrder(new Date(), accountId, headers);
        int orderInOneHour = orderResult.getOrderNumInLastOneHour();
        int totalValidOrder = orderResult.getOrderNumOfValidOrder();
//        int orderInOneHour = orderOtherResult.getOrderNumInLastOneHour() + orderResult.getOrderNumInLastOneHour();
//        int totalValidOrder = orderOtherResult.getOrderNumOfValidOrder() + orderResult.getOrderNumOfValidOrder();

        //2.获取关键配置信息
        SecurityConfig configMaxInHour = securityRepository.findByName("max_order_1_hour");
        SecurityConfig configMaxNotUse = securityRepository.findByName("max_order_not_use");
        int oneHourLine = Integer.parseInt(configMaxInHour.getValue());
        int totalValidLine = Integer.parseInt(configMaxNotUse.getValue());
        if (orderInOneHour > oneHourLine || totalValidOrder > totalValidLine) {
            return new mResponse<>(0, "Too much order in last one hour or too much valid order", accountId);
        } else {
            return new mResponse<>(1, "Success.r", accountId);
        }
    }

    private OrderSecurity getSecurityOrderInfoFromOrder(Date checkDate, String accountId) {
        String ret = "";
        try {
            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url("http://" + function21_URI + "/checkDate/" + checkDate + "/accountId/" + accountId)
                    .get()
                    .build();

            okhttp3.Response response = client.newCall(request).execute();
            ret = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse mRes = JsonUtils.json2Object(ret, mResponse.class);
        OrderSecurity result = JsonUtils.conveterObject(mRes.getData(), OrderSecurity.class);

        return result;
    }

//    private OrderSecurity getSecurityOrderOtherInfoFromOrder(Date checkDate, String accountId, HttpHeaders headers) {
//        SecurityServiceImpl.LOGGER.info("[Security Service][Get Order Other Info For Security] Getting....");
//        HttpEntity requestEntity = new HttpEntity(headers);
//        ResponseEntity<Response<OrderSecurity>> re = restTemplate.exchange(
//                "http://ts-order-other-service:12032/api/v1/orderOtherService/orderOther/security/" + checkDate + "/" + accountId,
//                HttpMethod.GET,
//                requestEntity,
//                new ParameterizedTypeReference<Response<OrderSecurity>>() {
//                });
//        Response<OrderSecurity> response = re.getBody();
//        OrderSecurity result = response.getData();
//        SecurityServiceImpl.LOGGER.info("[Security Service][Get Order Other Info For Security] Last One Hour: {}  Total Valid Order: {}", result.getOrderNumInLastOneHour(), result.getOrderNumOfValidOrder());
//        return result;
//    }

}
