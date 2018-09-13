$("#submiter").click(function(){
    
    $.post("/requests",
    {
        gnere: $("#inputMusic").val(),
        city: $("#inputCity").val()
    },
    function(data, status){
        console.log("Data: " + data + "\nStatus: " + status);
    });
});