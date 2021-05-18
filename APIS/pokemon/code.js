$('document').ready(function() {
    for (var i = 1;i<150;i++){
        $('.row').append('<div class="col"><img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/'+i+'.png"></div>')
    }
});