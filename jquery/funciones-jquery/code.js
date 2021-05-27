
$('document').ready(function() {

    $( "button" ).click(function() {
        let value = $(this).text();

        switch (value){
            case 'hide':
                $('.hide div h4').hide();
                $(this).text('show');
                break; 
            case 'show':
                $('.hide div h4').show();
                $(this).text('hide');
                break; 
            case 'toggle':
                $('.toggle div h4').toggle('slow');
                break; 
            case 'slideDown':
                $('.slide div h4').slideDown();
                $('.hide div h4').text('Title');
                $(this).text('slideUp');
                break; 
            case 'slideUp':
                $('.slide div h4').slideUp();
                $(this).text('slideDown');
                break; 
            case 'slideToggle':
                $('.slideToggle div h4').slideToggle();
                break; 
            case 'fadeOut':
                $('.fadeOut div h4').fadeOut('slow');
                $(this).text('fadeIn');
                break; 
            case 'fadeIn':
                $('.fadeOut div h4').fadeIn('slow');
                $(this).text('fadeOut');
                break; 
            case 'addClass':
                $('.addClass div h4').addClass('red');
                $(this).text('removeClass');
                break; 
            case 'removeClass':
                $('.addClass div h4').removeClass('red');
                $(this).text('addClass');
                break; 
            case 'before':
                $('.before div div').before('<p>before<p>');
                $(this).text('after');
                break; 
            case 'after':
                $('.before div div').after('<p>after<p>');
                $(this).text('before');
                break; 
            case 'append':
                $('.append div div').append('<p>add<p>');
                break; 
            case 'html':
                $('.html div div').html('<p>new p !!<p>');
                break; 
            case 'val':
                $('.val div div input').val('new value');
                break; 
            case 'text':
                $('.text div div p').text('new text');
                break; 
            case 'attr':
                alert("the value is : " + $('.attr div div input').attr("value"));
                break; 
        }
    });
});


