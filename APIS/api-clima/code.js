let key = "";

$('document').ready(function() {

    $( "button" ).click(function() {
        let city = $("#city").val();
        getData(city,key);
        $('#data').css('display','block');
    });

});

function getData(city,key){
    $.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+key, function(res) {
        $('.city').html(res.name);
        $('.result').html(res.weather[0].description);
        $('.temperature').html(res.main.temp);
        $('.coord').html(res.coord.lon+","+res.coord.lat);
    }, "json");
    
}

