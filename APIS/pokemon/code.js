$('document').ready(function() {
    for (var i = 1;i<150;i++){
        $('.row').append('<div id="'+i+'" class="col"><img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/'+i+'.png"></div>')
    }

    $( ".col" ).on( "click", function() {
        
        let id = $(this).attr('id');
        clearModal();
        completeModal(id);
        $('#myModal').modal('show');
      });
});

function completeModal(id){
    $.get("https://pokeapi.co/api/v2/pokemon/" + id + "/", function(res) {
        $('.title').append("<h3>" + res.name + "</h3>");
        $('.img').append("<img src='" + res.sprites.front_default + "'>");
        console.log( res.types[0].type.name);
        for (var i = 0; i < res.types.length; i++) {
            $('.types').append("<li>" + res.types[i].type.name + "</li>");
            console.log( res.types[i].type.name);
        }
        $('.weight').append("<p>" + res.weight + "</p>");
        $('.height').append("<p>" + res.height + "</p>");
    }, "json");
}
function clearModal(){
    $('.modal-body').html('<div class="row title"></div>'+
        '<div class="row img"></div>'+
        '<h5>Types</h5>'+
        '<ul class="types"></ul>'+
        '<h5>Height</h5>'+
        '<div class="height"></div>'+
        '<h5>Weight</h5>'+
        '<div class="weight"></div>'
    );
}

