
/**********************************************************************/
/********************Function For Route Service************************/
$("#refresh_route_button").click(function(){
    $("#refresh_route_button").attr("disabled",true);
    $("#route_list_status").text("false");
    $.ajax({
        type: "get",
        url: "/route/queryAll",
        contentType: "application/json",
        dataType: "json",
        xhrFields: {
            withCredentials: true
        },
        success: function (obj) {
            var result = obj["routes"];
            var size = result.length;
            $("#route_list_table").find("tbody").html("");
            for (var i = 0; i < size; i++) {
                $("#route_list_table").find("tbody").append(
                    "<tr>" +
                    "<td>" + i + "</td>" +
                    "<td class='all_route_id noshow_component'>" + result[i]["id"] + "</td>" +
                    "<td>" +
                        "<input class='all_route_start form-control' value='" + result[i]["startStationId"] + "'>" +
                    "</td>" +
                    "<td>" +
                    "<input class='all_route_end form-control' value='" + result[i]["terminalStationId"] + "'>" +
                    "</td>" +
                    "<td>" +
                        "<input class='all_route_stations form-control' value='" + result[i]["stations"] + "'>" +
                    "</td>" +
                    "<td>" +
                        "<input class='all_route_distances form-control' value='" + result[i]["distances"] + "'>" +
                    "</td>" +
                    "<td>" + "<button class='all_routes_update btn btn-primary'>Update</button>" + "</td>" +
                    "</tr>"
                );
            }
            addListenerToAllRouteTable();
            $("#route_list_status").text("true");
        },
        complete: function(){
            $("#refresh_route_button").attr("disabled",false);
        }
    });
});

function addListenerToAllRouteTable(){
    var allRouteUpdateBtnSet = $(".all_routes_update");
    for(var i = 0;i < allRouteUpdateBtnSet.length;i++){
        allRouteUpdateBtnSet[i].onclick = function(){

            var route = new Object();
            route.id = $(this).parents("tr").find(".all_route_id").text();;
            route.startStation = $(this).parents("tr").find(".all_route_start").val();
            route.endStation = $(this).parents("tr").find(".all_route_end").val();
            route.stationList = $(this).parents("tr").find(".all_route_stations").val();
            route.distanceList = $(this).parents("tr").find(".all_route_distances").val();

            var routeData = JSON.stringify(route);
            alert(routeData);

            //allRouteUpdateBtnSet[i].attr("disabled",true);
            $.ajax({
                type: "post",
                url: "/route/createAndModify",
                contentType: "application/json",
                dataType: "json",
                data:routeData,
                xhrFields: {
                    withCredentials: true
                },
                success: function(result){
                    var obj = result;
                    if(obj["status"] == true){
                        alert("Success");
                        //$("#create_route_create_message").html(obj["message"]);
                    }else{
                        alert("Update Fail");
                        //$("#create_route_create_message").html(obj["message"]);
                    }
                    //$("#create_route_status").html("true");
                },
                complete: function(){
                   // allRouteUpdateBtnSet[i].attr("disabled",false);
                }
            });

        }
    }
}

$("#create_route_button").click(function(){

    var startId = $("#route_start_id").val();
    var terminalId = $("#route_terminal_id").val();
    var passById = $("#route_pass_station_id").val();
    var passByDistance = $("#route_pass_distance_id").val();

    var newRoute = new Object();
    newRoute.id = "";
    newRoute.startStation = startId;
    newRoute.endStation = terminalId;
    newRoute.stationList = passById;
    newRoute.distanceList = passByDistance;
    var routeData = JSON.stringify(newRoute);

    $("#create_route_button").attr("disabled",true);
    $("#create_route_status").html("false");

    $.ajax({
        type: "post",
        url: "/route/createAndModify",
        contentType: "application/json",
        dataType: "json",
        data:routeData,
        xhrFields: {
            withCredentials: true
        },
        success: function(result){
            var obj = result;
            if(obj["status"] == true){
                $("#create_route_create_message").html(obj["message"]);
            }else{
                $("#create_route_create_message").html(obj["message"]);
            }
            $("#create_route_status").html("true");
        },
        complete: function(){
            $("#create_route_button").attr("disabled",false);
        }
    });

});