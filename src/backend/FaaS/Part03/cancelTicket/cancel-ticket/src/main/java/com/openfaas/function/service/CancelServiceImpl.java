package com.openfaas.function.service;

import com.openfaas.function.entity.*;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;


import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author fdse
 */
//@Service
public class CancelServiceImpl implements CancelService {

    private OkHttpClient client = new OkHttpClient();

    String function23_URI = "gateway.openfaas:8080/function/get-order-by-id.openfaas-fn";
    String function28_URI = "gateway.openfaas:8080/function/drawback.openfaas-fn";
    String function29_URI = "gateway.openfaas:8080/function/save-order-info.openfaas-fn";
//    private static final Logger LOGGER = LoggerFactory.getLogger(CancelServiceImpl.class);

    String orderStatusCancelNotPermitted = "Order Status Cancel Not Permitted";

    @Override
    public mResponse cancelOrder(String orderId, String loginId) {

        mResponse<Order> orderResult = getOrderByIdFromOrder(orderId);
        if (orderResult.getStatus() == 1) {
//            CancelServiceImpl.LOGGER.info("[Cancel Order Service][Cancel Order] Order found G|H");
            Order order = JsonUtils.conveterObject(orderResult.getData(),Order.class);
            if (order.getStatus() == OrderStatus.NOTPAID.getCode()
                    || order.getStatus() == OrderStatus.PAID.getCode() || order.getStatus() == OrderStatus.CHANGE.getCode()) {

                order.setStatus(OrderStatus.CANCEL.getCode());

                mResponse changeOrderResult = cancelFromOrder(order);
                // 0 -- not find order   1 - cancel success
                if (changeOrderResult.getStatus() == 1) {

//                    CancelServiceImpl.LOGGER.info("[Cancel Order Service][Cancel Order] Success.");
                    //Draw back money
                    String money = calculateRefund(order);
                    boolean status = drawbackMoney(money, loginId);
                    if (status) {
//                        CancelServiceImpl.LOGGER.info("[Cancel Order Service][Draw Back Money] Success.");

//                        Response<User> result = getAccount(order.getAccountId().toString(), headers);
//                        if (result.getStatus() == 0) {
//                            return new Response<>(0, "Cann't find userinfo by user id.", null);
//                        }
//                        NotifyInfo notifyInfo = new NotifyInfo();
//                        notifyInfo.setDate(new Date().toString());
//                        notifyInfo.setEmail(result.getData().getEmail());
//                        notifyInfo.setStartingPlace(order.getFrom());
//                        notifyInfo.setEndPlace(order.getTo());
//                        notifyInfo.setUsername(result.getData().getUserName());
//                        notifyInfo.setSeatNumber(order.getSeatNumber());
//                        notifyInfo.setOrderNumber(order.getId().toString());
//                        notifyInfo.setPrice(order.getPrice());
//                        notifyInfo.setSeatClass(SeatClass.getNameByCode(order.getSeatClass()));
//                        notifyInfo.setStartingTime(order.getTravelTime().toString());
//
//                        sendEmail(notifyInfo, headers);

                    } else {
//                        CancelServiceImpl.LOGGER.info("[Cancel Order Service][Draw Back Money] Fail.");
                    }
                    return new mResponse<>(1, "Success.", null);
                } else {
//                    CancelServiceImpl.LOGGER.info("[Cancel Order Service][Cancel Order] Fail.Reason: {}", changeOrderResult.getMsg());
                    return new mResponse<>(0, changeOrderResult.getMsg(), null);
                }

            } else {
//                CancelServiceImpl.LOGGER.info("[Cancel Order Service][Cancel Order] Order Status Not Permitted.");
                return new mResponse<>(0, orderStatusCancelNotPermitted, null);
            }
        } else {
//            CancelServiceImpl.LOGGER.info("[Cancel Order Service][Cancel Order] Order Not Found.");
            return new mResponse<>(0, "Order Not Found.", null);
        }
    }

//    public boolean sendEmail(NotifyInfo notifyInfo, HttpHeaders headers) {
//        CancelServiceImpl.LOGGER.info("[Cancel Order Service][Send Email]");
//        HttpEntity requestEntity = new HttpEntity(notifyInfo, headers);
//        ResponseEntity<Boolean> re = restTemplate.exchange(
//                "http://ts-notification-service:17853/api/v1/notifyservice/notification/order_cancel_success",
//                HttpMethod.POST,
//                requestEntity,
//                Boolean.class);
//        return re.getBody();
//    }

    private String calculateRefund(Order order) {
        if (order.getStatus() == OrderStatus.NOTPAID.getCode()) {
            return "0.00";
        }
//        CancelServiceImpl.LOGGER.info("[Cancel Order] Order Travel Date: {}", order.getTravelDate().toString());
        Date nowDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(order.getTravelDate());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(order.getTravelTime());
        int hour = cal2.get(Calendar.HOUR);
        int minute = cal2.get(Calendar.MINUTE);
        int second = cal2.get(Calendar.SECOND);
        Date startTime = new Date(year,  //NOSONAR
                month,
                day,
                hour,
                minute,
                second);
//        CancelServiceImpl.LOGGER.info("[Cancel Order] nowDate  : {}", nowDate);
//        CancelServiceImpl.LOGGER.info("[Cancel Order] startTime: {}", startTime);
        if (nowDate.after(startTime)) {
//            CancelServiceImpl.LOGGER.info("[Cancel Order] Ticket expire refund 0");
            return "0";
        } else {
            double totalPrice = Double.parseDouble(order.getPrice());
            double price = totalPrice * 0.8;
            DecimalFormat priceFormat = new java.text.DecimalFormat("0.00");
            String str = priceFormat.format(price);
//            CancelServiceImpl.LOGGER.info("[Cancel Order]calculate refund - {}", str);
            return str;
        }
    }

    private mResponse cancelFromOrder(Order order) {

        String ret = "";
        String json = JsonUtils.object2Json(order);
        try {
            RequestBody body = RequestBody.create(
                    MediaType.parse("application/json"), json);

            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url("http://" + function29_URI)
                    .post(body)
                    .build();

            okhttp3.Response response = client.newCall(request).execute();
            ret = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse result = JsonUtils.json2Object(ret, mResponse.class);
        return result;
    }

    public boolean drawbackMoney(String money, String userId) {
//        CancelServiceImpl.LOGGER.info("[Cancel Order Service][Draw Back Money] Draw back money...");
        String ret = "";
        try {
            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url("http://" + function28_URI + "/userId/" + userId+ "/money/" + money)
                    .get()
                    .build();

            okhttp3.Response response = client.newCall(request).execute();
            ret = response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse<Order> result = JsonUtils.json2Object(ret, mResponse.class);
        return result.getStatus() == 1;
    }

//    public mResponse<User> getAccount(String orderId, HttpHeaders headers) {
//        CancelServiceImpl.LOGGER.info("[Cancel Order Service][Get By Id]");
//        HttpEntity requestEntity = new HttpEntity( headers);
//        ResponseEntity<Response<User>> re = restTemplate.exchange(
//                "http://ts-user-service:12342/api/v1/userservice/users/id/" + orderId,
//                HttpMethod.GET,
//                requestEntity,
//                new ParameterizedTypeReference<Response<User>>() {
//                });
//        return re.getBody();
//    }


    //func23
    private mResponse<Order> getOrderByIdFromOrder(String orderId) {
//        CancelServiceImpl.LOGGER.info("[Cancel Order Service][Get Order] Getting....");
        String ret = "";
        try {
            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url("http://" + function23_URI + "/orderId/" + orderId)
                    .get()
                    .build();

            okhttp3.Response response = client.newCall(request).execute();
            ret = response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }
                System.out.println(ret);

        mResponse<Order> result = JsonUtils.json2Object(ret, mResponse.class);
        return result;
    }

}
