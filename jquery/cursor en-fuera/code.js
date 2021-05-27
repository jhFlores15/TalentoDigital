$('document').ready(function() {

    $( ".box img" ).hover(function() {
        let source =  $(this).attr('data-src-alt');
        let src = $(this).attr('src');

        $(this).attr('data-src-alt',src)
        $(this).attr('src',source);

    },function() {
        let source =  $(this).attr('data-src-alt');
        let src = $(this).attr('src');

        $(this).attr('data-src-alt',src)
        $(this).attr('src',source)

    });

});