$('document').ready(function() {

    $( "#main_container .box" ).click(function() {
        $(this).hide();
    });

    $( "button" ).click(function() {
        $("#main_container .box").show();
        $( ".buttonClass" ).append( $( "<button>Add</button>" ) );
    });

    $(document).on('click', 'button', function(){alert('you clicked a button!')});

});