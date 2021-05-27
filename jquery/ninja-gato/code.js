$('document').ready(function() {
    
    $( "button" ).click(function() {
        location.reload();
    });

    $( "img" ).click(function() {
        //let source =  $(this).attr('data-alt-src');
        //$(this).attr('src',source);

        let imgSource =  $(this).attr('img-src');
        let src = $(this).attr('src');

        if(imgSource == 'cat'){
            src = src.replace("cat", "ninja");
            imgSource = "ninja";
        }
        else{
            src = src.replace("ninja", "cat");
            imgSource = "cat";
        }

        $(this).attr('src',src);
        $(this).attr('img-src',imgSource);
        
    });
});


