/**
 *Dados un array y un valor Y, cuenta e imprime (print) el número de valores del array que sean mayores que Y. 
 */


 function suma(array){
    var sum = 0;
    for(var i=0; i<array.length; i++){
        if(array[i] > 7){
            console.log(array[i]);
            sum = sum + array[i];
        }
    }
   return sum;
 }
 var array = [2,3,8,5,6,12];
 console.log(suma(array));


/**
 *Dado un array, imprime los valores máximos (max), mínimos (min) y promedio (average) para el array. 
 */

 function prom(array){
    var sum=0;
    var min=array[0];
    var max=array[0];
    for(var i=0; i<array.length; i++){
        sum = sum + array[i];
        if(min > array[i]){
            min = array[i];
        }
        if(max < 7){
            max = array[i];
        }
    }
    console.log("min "+ min);
    console.log("max " + max);
    console.log("avg " + sum/array.length);
 }

 var array=[2,3,4,5,1,8];
 prom(array);

/**
 *Dado un array de números, crea una función que dé como resultado un nuevo array donde los valores negativos se reemplacen por el texto (string) ‘Dojo’. 
 *Por ejemplo, reemplazarNegativos([1,2,-3,-5,5]) debiera devolver [1,2, “Dojo”, “Dojo”, 5].
 */

 function reemplazarNegativos(array){
    for(var i=0; i<array.length; i++){
        if(array[i] < 0){
            array[i] = "Dojo";
        }
    }

    return array;
 }
 
 var array = [1,2,-3,-5,5];
console.log( reemplazarNegativos(array));





/**
 * Dado un array y su respectivo índice, remueve los valores en el rango del índice dado( acortando el array). 
 * Por ejemplo, removerRango([20,30,40,50,60,70],2,4)
 * debiera devolver [20,30,70].
 */


function removerRango(array,x,y){
    var cantidad = y-x+1;

    while(cantidad > 0){
        array.splice(x, 1);
        cantidad--;
    }

    return array;
}


var array = [20, 30, 40, 50, 60, 70];
console.log(removerRango(array, 2, 4));