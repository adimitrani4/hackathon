$("#submiter").click(function(){
    // Create a request variable and assign a new XMLHttpRequest object to it.
    var request = new XMLHttpRequest();

    // using the GET request to get location
    request.open('GET', 'https://api.songkick.com/api/3.0/search/locations.json?query=city:'
    +$("#inputCity").val()+'&apikey=XFK6hX8iZ4LjPg6l', true);

    request.onload = function () {
      // Begin accessing JSON data here
      var data = JSON.parse(this.response);
      }
    }
    // Send request
    request.send();

    $.post("/requests",
    {
        gnere: $("#inputMusic").val(),
        city: $("#inputCity").val()
        json:
    },
    function(data, status){
        console.log("Data: " + data + "\nStatus: " + status);
    });
});