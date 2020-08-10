/*************************************************************************/
/********************Function For Register Service************************/
/********************Used for Register Service Single Microservice Test***/

$("#register_button").click(function() {
    var registerInfo = new Object();
    registerInfo.password = $("#register_password").val();
    if(registerInfo.password == null || registerInfo.password == ""){
        alert("Please input your password to register.");
        return;
    }
    registerInfo.gender = $("#register_gender").val();
    if(registerInfo.gender == null || registerInfo.gender == ""){
        alert("Please select your gender to register.");
        return;
    }
    registerInfo.name = $("#register_name").val();
    if(registerInfo.name == null || registerInfo.name == ""){
        alert("Please input your name to register.");
        return;
    }
    registerInfo.documentType = $("#register_documentType").val();
    if(registerInfo.documentType == null || registerInfo.documentType == ""){
        alert("Please select your document type to register.");
        return;
    }
    registerInfo.documentNum = $("#register_documentNum").val();
    if(registerInfo.documentNum == null || registerInfo.documentNum == ""){
        alert("Please input your document number to register.");
        return;
    }
    registerInfo.email = $("#register_email").val();
    if(registerInfo.email == null || registerInfo.email == ""){
        alert("Please input your email to register.");
        return;
    }
    registerInfo.verificationCode = $("#register_verificationCode").val();
    if(registerInfo.verificationCode == null || registerInfo.verificationCode == ""){
        alert("Please input verification code to register.");
        return;
    }
    var data = JSON.stringify(registerInfo);
    $("#register_button").attr("disabled",true);
    $("#register_result_status").text("false");
    $.ajax({
        type: "post",
        url: "/register",
        contentType: "application/json",
        dataType: "json",
        data:data,
        xhrFields: {
            withCredentials: true
        },
        success: function(result){
            if(result["status"] == true){
                //
            }
            $("#register_result_status").text("true");
            var obj = result;
            //$("#register_result_status").html(JSON.stringify(obj["status"]));
            $("#register_result_msg").html(obj["message"]);
            $("#register_result_account").html(JSON.stringify(obj["account"]));
        },
        complete: function(){
            $("#register_button").attr("disabled",false);
        }
    });
});

