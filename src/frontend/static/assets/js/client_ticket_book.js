function parseURL() {
    var thisUrl = document.URL;
    var getVal = thisUrl.split('?')[1];
    var showVal = getVal.split("&");

    var tripId = showVal[0].split("=")[1];
    var from = showVal[1].split("=")[1].replace("%20", " ");
    var to = showVal[2].split("=")[1].replace("%20", " ");
    var seatType = showVal[3].split("=")[1];
    var seatPrice = showVal[4].split("=")[1];
    if (seatType == "2" || seatType == 2) {
        seatType = "confort seat";
    } else {
        seatType = "economy seat";
    }
    var date = showVal[5].split("=")[1];

    $("#tickets_booking_list_table").find("tbody").append(
        "<tr>" +
        "<td id ='booking_tripId' class='booking_tripId'>" + tripId + "</td>" +
        "<td class='booking_from'>" + from + "</td>" +
        "<td class='booking_to'>" + to + "</td>" +
        "<td class='booking_seatType'>" + seatType + "</td>" +
        "<td class='booking_seatPrice'>" + seatPrice + "</td>" +
        "<td class='booking_date'> " + date + "</td>" +
        "</tr>"
    );
    bookingPage(tripId, from, to, date);


}

var bookingPage = function (tripId, from, to, date) {
    var username = sessionStorage.getItem("client_name");
    if (username == null || username == 'Not Login') {
        //alert("Please login first!");
        location.href = "client_login.html";
    } else {
        document.getElementById("client_name").innerHTML = username;
        // initFoodSelect(tripId, from, to, date);
        refresh_booking_contacts();
    }
};

$("#refresh_booking_contacts_button").click(function () {
    refresh_booking_contacts();
});

function refresh_booking_contacts() {
    console.log("refresh contacts")
    if (sessionStorage.getItem("client_token") == null || sessionStorage.getItem("client_id") == null) {
        alert("Please Login");
    }

    $("#refresh_booking_contacts_button").attr("disabled", true);
    $.ajax({
        type: "get",
        url: "/function/find-contacts-by-accountid.openfaas-fn/accountId/" + sessionStorage.getItem("client_id"),
        contentType: "text/plain",
        dataType: "json",
        headers: {"Authorization": "Bearer " + sessionStorage.getItem("client_token")},
        xhrFields: {
            withCredentials: true
        },
        success: function (result) {
            var obj = result.data;
            $("#contacts_booking_list_table").find("tbody").html("");
            for (var i = 0, l = obj.length; i < l; i++) {
                $("#contacts_booking_list_table").find("tbody").append(
                    "<tr>" +
                    "<td>" + i + "</td>" +
                    "<td class='booking_contacts_contactsId' style='display:none'>" + obj[i]["id"] + "</td>" +
                    "<td class='booking_contacts_name'>" + obj[i]["name"] + "</td>" +
                    "<td class='booking_contacts_documentType'>" + convertNumberToDocumentType(obj[i]["documentType"]) + "</td>" +
                    "<td class='booking_contacts_documentNumber'>" + obj[i]["documentNumber"] + "</td>" +
                    "<td class='booking_contacts_phoneNumber'>" + obj[i]["phoneNumber"] + "</td>" +
                    "<td>" + "<label><input class='booking_contacts_select' name='booking_contacts' type='radio' />" + "Select" + "</label>" + "</td>" +
                    "</tr>"
                );
            }
            $("#contacts_booking_list_table").find("tbody").append(
                "<tr>" +
                "<td>" + obj.length + "</td>" +
                "<td class='booking_contacts_name'>" + "<input id='booking_new_contacts_name'>" + "</td>" +
                "<td>" +
                "<select id='booking_new_contacts_documentType' class='booking_contacts_documentType all form-control'>" +
                "<option value='1' selected = 'selected'>ID Card</option>" +
                "<option value='2'>Passport</option>" +
                "<option value='3'>Other</option>" +
                "</select>" +
                "</td>" +
                "<td class='booking_contacts_documentNumber'>" + "<input id='booking_new_contacts_documentNum'>" + "</td>" +
                "<td class='booking_contacts_phoneNumber'>" + "<input id='booking_new_contacts_phoneNum'>" + "</td>" +
                "<td>" + "<label><input id='booking_new_contacts_select' class='booking_contacts_select' name='booking_contacts' type='radio' />" + "Select" + "</label>" + "</td>" +
                "</tr>"
            );
        }, error: function (e) {
            if (e.message.indexOf("Token")) {
                alert("Token is expired! please login first!");
            }
        },
        complete: function () {
            $("#refresh_booking_contacts_button").attr("disabled", false);
        }
    });
}


function convertNumberToDocumentType(code) {
    var str = "";
    if (code == 0) {
        str = "null";
    } else if (code == 1) {
        str = "ID Card";
    } else if (code == 2) {
        str = "Passport";
    } else {
        str = "other";
    }
    return str;
}

$("#ticket_select_contacts_cancel_btn").click(function () {
    location.hash = "anchor_flow_preserve_select_trip";
});

$("#ticket_select_contacts_confirm_btn").click(function () {

    var thisUrl = document.URL;
    var getVal = thisUrl.split('?')[1];
    var showVal = getVal.split("&");

    var tripId = showVal[0].split("=")[1];
    var from = showVal[1].split("=")[1].replace("%20", " ");
    var to = showVal[2].split("=")[1].replace("%20", " ");
    var seatType = showVal[3].split("=")[1];

    var seatPrice = showVal[4].split("=")[1];
    if (seatType == "2" || seatType == 2) {
        seatType = "confort seat";
    } else {
        seatType = "economy seat";
    }
    var date = showVal[5].split("=")[1];
    if (sessionStorage.getItem("client_id") == "-1" || sessionStorage.getItem("client_id") == null) {
        alert("Please Login!");
    }
    var contactsId = "";
    var radios = $(".booking_contacts_select");
    var selectContactsStatus = false;

    var contactsName = "";
    var documentType = "";
    var documentNumber = "";

    // add new contact
    if (radios[radios.length - 1].checked) {
        selectContactsStatus = true;
        preserveCreateNewContacts();
    } else {
        for (var j = 0; j < radios.length - 1; j++) {
            if (radios[j].checked) {
                contactsId = $(".booking_contacts_contactsId").eq(j).text();
                selectContactsStatus = true;
                contactsName = $(".booking_contacts_name").eq(j).text();
                documentType = $(".booking_contacts_documentType").eq(j).text();
                documentNumber = $(".booking_contacts_documentNumber").eq(j).text();

                $('#sub_consNum').text(contactsId);
                $('#sub_name').text(contactsName);
                $('#sub_docType').text(documentType);
                $('#sub_docNumber').text(documentNumber);
            }
        }
    }


    $('#sub_startP').text(from);
    $('#sub_endP').text(to);
    $('#sub_tripId').text(tripId);
    $('#sub_price').text(seatPrice);
    $('#sub_date').text(date);
    $('#sub_setType').text(seatType);

    if ($('#assurance_type').find("option:selected").val() == 1) {
        var type = $('#assurance_type').find("option:selected").text();
        console.log("assurance type " + type);
        $('#sub_assurance').text(type);
        $('#sub_assurance_h').css("display", "block");
    } else {
        $('#sub_assurance_h').css("display", "none");
    }


    if ($('#need-food-or-not').is(":checked")) {
        var type = $('#preserve_food_type').find("option:selected").text();
        $('#sub_foodType_h').css("display", "block");
        $('#sub_foodName_h').css("display", "block");
        $('#sub_foodPrice_h').css("display", "block");
        $('#sub_foodType').text(type);

        if ($('#preserve_food_type').find("option:selected").val() == 1) {
            var fp = $('#train-food-type-list').find("option:selected").text().split(":");
            $('#sub_foodName').text(fp[0]);
            $('#sub_foodPrice').text(fp[1]);
            $('#sub_foodStation_h').css("display", "block");
            $('#sub_storeName_h').css("display", "block");
        } else {
            var fp2 = $('#food-store-food-list').find("option:selected").text().split(":");
            $('#sub_foodName').text(fp2[0]);
            $('#sub_foodPrice').text(fp2[1]);
            $('#sub_foodStation').text($('#food-station-list').find("option:selected").text());
            $('#sub_storeName').text($('#food-stores-list').find("option:selected").text());
            $('#sub_foodStation_h').css("display", "block");
            $('#sub_storeName_h').css("display", "block");
        }
    } else {
        $('#sub_foodType_h').css("display", "none");
        $('#sub_foodName_h').css("display", "none");
        $('#sub_foodPrice_h').css("display", "none");
        $('#sub_foodStation_h').css("display", "none");
        $('#sub_storeName_h').css("display", "none");
    }

    //Show the consign information
    if ($('#need-consign-or-not').is(":checked")) {
        $('#sub_consignse_h').css("display", "block");
        $('#sub_consName').text($("#name_of_consignee ").val());
        $('#sub_consPhone').text($(" #phone_of_consignee ").val());
        $('#sub_consWeight').text($(" #weight_of_consign ").val());
    } else {
        $('#sub_consignse_h').css("display", "none");
    }


    if (selectContactsStatus == false) {
        alert("Please select contacts.");
        return;
    }

    if (selectContactsStatus == true) {
        $('#my-prompt').modal({
            relatedTarget: this,
            onConfirm: function (e) {
                //  submit   ticket

                var orderTicketInfo = new Object();

                orderTicketInfo.accountId = sessionStorage.getItem("client_id");
                orderTicketInfo.contactsId = $("#sub_consNum").text();
                orderTicketInfo.tripId = $("#sub_tripId").text();

                if ($("#sub_setType").text().indexOf("confort") >= 0) {
                    orderTicketInfo.seatType = "2";
                } else {
                    orderTicketInfo.seatType = "3";
                }

                orderTicketInfo.date = $("#sub_date").text();
                orderTicketInfo.from = $("#sub_startP").text();
                orderTicketInfo.to = $("#sub_endP").text();
                orderTicketInfo.assurance = $("#assurance_type").val();

                // add ausrance
                if (null != $('#sub_assurance').text() && "" != $('#sub_assurance').text()) {
                    // assurance type
                    orderTicketInfo.assurance = $('#assurance_type').find("option:selected").val();
                }
                //add the food information
                if (null != $('#sub_foodType').text() && "" != $('#sub_foodType').text()) {
                    if ($('#sub_foodType').text().indexOf("Train")) {
                        orderTicketInfo.foodType = 1;
                        orderTicketInfo.foodName = $('#sub_foodName').text();
                        orderTicketInfo.foodPrice = parseFloat($('#sub_foodPrice').text().substr(1));
                        orderTicketInfo.stationName = "";
                        orderTicketInfo.storeName = "";
                    } else if ($('#sub_foodType').text().indexOf("Station")) {
                        orderTicketInfo.foodType = 2;
                        orderTicketInfo.stationName = $('#sub_foodStation').text();
                        orderTicketInfo.storeName = $('#sub_storeName').text();
                        orderTicketInfo.foodName = $('#sub_foodName').text();
                        orderTicketInfo.foodPrice = parseFloat($('#sub_foodPrice').text().substr(1));
                    } else {
                        orderTicketInfo.foodType = 0;
                    }
                } else {
                    orderTicketInfo.foodType = 0;
                }
                //Add the consign information
                if ($('#need-consign-or-not').is(":checked")) {
                    var date = new Date();
                    var seperator1 = "-";
                    var year = date.getFullYear();
                    var month = date.getMonth() + 1;
                    var strDate = date.getDate();
                    if (month >= 1 && month <= 9) {
                        month = "0" + month;
                    }
                    if (strDate >= 0 && strDate <= 9) {
                        strDate = "0" + strDate;
                    }
                    var currentdate = year + seperator1 + month + seperator1 + strDate;
                    orderTicketInfo.handleDate = currentdate;
                    orderTicketInfo.consigneeName = $("#name_of_consignee ").val();
                    orderTicketInfo.consigneePhone = $("#phone_of_consignee ").val();
                    orderTicketInfo.consigneeWeight = parseFloat($("#weight_of_consign ").val());
                    orderTicketInfo.isWithin = false;
                }

                var orderTicketsData = JSON.stringify(orderTicketInfo);
                console.log("orderTicketsData:");
                console.log(orderTicketsData);

                path = "function/preserve-ticket.openfaas-fn";
                // path = "http://127.0.0.1:8094";


                $('#my-svg').shCircleLoader({namespace: 'runLoad'});

                $.ajax({
                    type: "post",
                    url: path,
                    contentType: "text/plain",
                    dataType: "json",
                    data: orderTicketsData,
                    headers: {"Authorization": "Bearer " + sessionStorage.getItem("client_token")},

                    xhrFields: {
                        withCredentials: true
                    },
                    success: function (result) {
                        console.log(result);
                        if (result.status == 1) {
                            $('#my-svg').shCircleLoader('destroy');
                            alert(result["msg"] + "---" + "please go to order list to pay for it!");
                        } else {
                            alert(result["msg"]);
                        }
                    }, error: function (e) {
                        var message = e.responseJSON.message;
                        console.log(message);
                        if (message.indexOf("Token") != -1) {
                            alert("Token is expired! please login first!");
                        }
                    },
                    complete: function () {
                        $('#my-svg').shCircleLoader('destroy');
                        $("#ticket_confirm_confirm_btn").attr("disabled", false);
                    }
                })

            },
            onCancel: function (e) {
                // alert('cancel!');
            }
        });
        // location.hash = "anchor_flow_preserve_confirm";
    }
});

function preserveCreateNewContacts() {

    if (sessionStorage.getItem("client_id") == "-1" || sessionStorage.getItem("client_id") == null) {
        alert("Please Login.");
    }

    $("#ticket_select_contacts_confirm_btn").attr("disabled", true);
    var addContactsInfo = new Object();
    addContactsInfo.name = $("#booking_new_contacts_name").val();
    addContactsInfo.accountId = sessionStorage.getItem("client_id");
    addContactsInfo.documentType = $("#booking_new_contacts_documentType").val();
    addContactsInfo.documentNumber = $("#booking_new_contacts_documentNum").val();
    addContactsInfo.phoneNumber = $("#booking_new_contacts_phoneNum").val();

    var data = JSON.stringify(addContactsInfo);
    $.ajax({
        type: "post",
        url: "/function/create-new-contacts.openfaas-fn",
        contentType: "text/plain",
        headers: {"Authorization": "Bearer " + sessionStorage.getItem("client_token")},
        dataType: "json",
        data: data,
        xhrFields: {
            withCredentials: true
        },
        success: function (result) {
            // 设置弹框里面的值
            $('#sub_consNum').text(result.data["id"]);
            $('#sub_name').text(result.data["name"]);
            $('#sub_docType').text(convertNumberToDocumentType(result.data["documentType"]));
            $('#sub_docNumber').text(result.data["documentNumber"]);

            $("#ticket_confirm_contactsId").text(result.data["id"]);
            $("#ticket_confirm_contactsName").text(result.data["name"]);
            $("#ticket_confirm_documentType").text(convertNumberToDocumentType(result.data["documentType"]));
            $("#ticket_confirm_documentNumber").text(result.data["documentNumber"]);
            refresh_booking_contacts();
        }, error: function (e) {

            var message = e.responseJSON.message;
            console.log(message);
            if (message.indexOf("Token") != -1) {
                alert("Token is expired! please login first!");
            }
        },
        complete: function () {
            $("#ticket_select_contacts_confirm_btn").attr("disabled", false);
        }
    });
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0)
            return c.substring(name.length, c.length);
    }
    return "";
}