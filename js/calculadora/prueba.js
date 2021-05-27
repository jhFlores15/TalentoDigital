let string = "673254732.23647+376587";
let regex = new RegExp("^([0-9]+[.]?[-+*\/]?)*$");
console.log(regex.test(string));

$(document).ready(function() {
    $("button").click(function() {
        let ultimoCaracter = string.charAt(string.length-1);
        let value = $(this).text();
        
        if(ultimoCaracter != "-" && ultimoCaracter != "+" && ultimoCaracter != "/" && ultimoCaracter != "*"){
            if(string.length == 0){
                if(value != "-" && value != "+"  && value != "/"  && value != "*"  ){
                    string += value;
                    $("#txtNumeros").val(string);
                }
            }
            else{
                string += value;
                $("#txtNumeros").val(string);
            
            }
        }
        else{
            string = string.slice(0,string.length-1);
            string += value;
            $("#txtNumeros").val(string);
        }
        
       
    });
});