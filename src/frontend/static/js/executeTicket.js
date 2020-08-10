
/**************************************************************************/
/********************Function For Ticket Execute Service*******************/
/********************For Execute Ticket Service Single Microservice Test***/

$("#execute_order_button").click(function() {
    var executeInfo = new Object();
    executeInfo.orderId = $("#execute_order_id").val();
    if(executeInfo.orderId == null || executeInfo.orderId == ""){
        alert("Please input the order number you want to use.");
        return;
    }
    var data = JSON.stringify(executeInfo);
    $("#execute_order_button").attr("disabled",true);
    $("#execute_order_status").text("false");
    $.ajax({
        type: "post",
        url: "/execute/execute",
        contentType: "application/json",
        dataType: "json",
        data:data,
        xhrFields: {
            withCredentials: true
        },
        success: function(result){
            var obj = result;
            if(obj["status"] == true){
                $("#execute_order_message").html(obj["message"]);
            }else{
                $("#execute_order_message").html(obj["message"]);
            }
            $("#execute_order_status").text("true");
        },
        complete: function(){
            $("#execute_order_button").attr("disabled",false);
        }
    });
});

/*****************For Collect Ticket Single Microservice Test********/

$("#single_collect_button").click(function() {
    var executeInfo = new Object();
    executeInfo.orderId = $("#single_collect_order_id").val();
    if(executeInfo.orderId == null || executeInfo.orderId == ""){
        alert("Please input the order number you want to collect.");
        return;
    }
    var data = JSON.stringify(executeInfo);
    $("#single_collect_button").attr("disabled",true);
    $("#single_collect_order_status").text("false");
    $.ajax({
        type: "post",
        url: "/execute/collected",
        contentType: "application/json",
        dataType: "json",
        data:data,
        xhrFields: {
            withCredentials: true
        },
        success: function(result){
            var obj = result;
            if(obj["status"] == true){
                $("#single_collect_order_result").html(obj["message"]);
            }else{
                $("#single_collect_order_result").html(obj["message"]);
            }
            $("#single_collect_order_status").text("true");
        },
        complete: function(){
            $("#single_collect_button").attr("disabled",false);
        }
    });
});;

