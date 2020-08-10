package com.openfaas.function.service;

import com.openfaas.function.entity.*;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;
import okhttp3.OkHttpClient;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author fdse
 */

public class CancelServiceImpl implements CancelService {

    //    private static final Logger LOGGER = LoggerFactory.getLogger(CancelServiceImpl.class);
    private OkHttpClient client = new OkHttpClient();
    String function23_URI = "gateway.openfaas:8080/function/get-order-by-id.openfaas-fn";


    @Override
    public mResponse calculateRefund(String orderId) {

        mResponse<Order> orderResult = getOrderByIdFromOrder(orderId);
        if (orderResult.getStatus() == 1) {
            Order order = JsonUtils.conveterObject(orderResult.getData(),Order.class);
            if (order.getStatus() == OrderStatus.NOTPAID.getCode()
                    || order.getStatus() == OrderStatus.PAID.getCode()) {
                if (order.getStatus() == OrderStatus.NOTPAID.getCode()) {
//                    CancelServiceImpl.LOGGER.info("[Cancel Order][Refund Price] From Order Service.Not Paid.");
                    return new mResponse<>(1, "Success. Refoud 0", 0);
                } else {
//                    CancelServiceImpl.LOGGER.info("[Cancel Order][Refund Price] From Order Service.Paid.");
                    return new mResponse<>(1, "Success. ", calculateRefund(order));
                }
            } else {
//                CancelServiceImpl.LOGGER.info("[Cancel Order][Refund Price] Order. Cancel Not Permitted.");
                return new mResponse<>(0, "Order Status Cancel Not Permitted, Refound error", null);
            }
        } else {
//            CancelServiceImpl.LOGGER.info("[Cancel Order][Refund Price] Order not found.");
            return new mResponse<>(0, "Order Not Found", null);
        }
    }

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

    private mResponse<Order> getOrderByIdFromOrder(String orderId) {
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
        mResponse<Order> result = JsonUtils.json2Object(ret, mResponse.class);
        return result;
    }

}
