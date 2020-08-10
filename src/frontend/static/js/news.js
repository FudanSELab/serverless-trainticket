

$("#refresh_news_button").click(function(){
    $.ajax({
        type: "get",
        url: "/news-service/news",
        contentType: "application/json",
        dataType: "json",
        xhrFields: {
            withCredentials: true
        },
        success: function(result){
            $("#news_div").html("");
            for(var i = 0;i < result.length;i++){
                alert(result[i]["Title"]);
                alert(result[i]["Content"]);
                $("#news_div").append(
                    "<div class='panel-heading'>" +
                        "<h3 class='panel-title'>" +
                            result[i]["Title"] +
                        "</h3>" +
                    "</div>" +
                    "<div class='input-box panel-body'>" +
                        result[i]["Content"] +
                    "</div>"
                );
            }
        }
    });
});
