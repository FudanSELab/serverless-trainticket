/*****************************************************************************/
/********************Function For Order Cancel Service************************/
/********************Used For Order Cancel Service Single Microservice Test***/

$("#single_cancel_button").click(function(){
    document.cookie="loginToken=admin";
    var cancelOrderInfo = new Object();
    cancelOrderInfo.orderId =  $("#single_cancel_order_id").val();
    if(cancelOrderInfo.orderId == null || cancelOrderInfo.orderId == ""){
        alert("Please input the order ID that you want to cancel.");
        return;
    }
    var cancelOrderInfoData = JSON.stringify(cancelOrderInfo);
    $("#single_cancel_button").attr("disabled",true);
    $("#single_cancel_order_status").text("false");
    $.ajax({
        type: "post",
        url: "/cancelOrder",
        contentType: "application/json",
        dataType: "json",
        data: cancelOrderInfoData,
        xhrFields: {
            withCredentials: true
        },
        success: function (result) {
            $("#single_cancel_order_result").text(result["message"]);
            if(result["status"] == true){
                //
            }
            $("#single_cancel_order_status").text("true");
        },
        complete: function(){
            $("#single_cancel_button").attr("disabled",false);
        }
    });
});

$("#single_cancel_refund_button").click(function(){
    var cancelOrderInfo = new Object();
    cancelOrderInfo.orderId =  $("#single_cancel_order_id").val();
    if(cancelOrderInfo.orderId == null || cancelOrderInfo.orderId == ""){
        alert("Please input the order ID that you want to cancel.");
        return;
    }
    var cancelOrderInfoData = JSON.stringify(cancelOrderInfo);
    $("#single_cancel_refund_button").attr("disabled",true);
    $("#single_cancel_refund_status").text("false");
    $.ajax({
        type: "post",
        url: "/cancelCalculateRefund",
        contentType: "application/json",
        dataType: "json",
        data: cancelOrderInfoData,
        xhrFields: {
            withCredentials: true
        },
        success: function (result) {
            $("#single_cancel_refund_result").text(result["refund"]);
            if(result["status"] == true){
                //
            }
            $("#single_cancel_refund_status").text("true");
        },
        complete: function(){
            $("#single_cancel_refund_button").attr("disabled",false);
        }
    });
});
