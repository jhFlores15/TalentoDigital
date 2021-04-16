/**
 * Configura un array para que los valores negativos se transformen en 0. 
 * Por ejemplo, resetNegativos([1,2,-1,-3]) debiera dar como resultado [1,2,0,0].
 */
 function resetNegativos(array){
    for(var i=0; i<array.length; i++){
        if(array[i] < 0){
            array[i] = 0;
        }
    }
  
  return array;
}
var array = [1,2,-1,-3];
var newArray = resetNegativos(array);
console.log(newArray);

/**
 * Dado un array, mueve todos los valores un espacio de derecha a izquierda eliminando el primer valor y dejando un 0 para el último valor. 
 * Por ejemplo, moverAdelante([1,2,3]) debiera dar como resultado [2,3,0].
 */

function moverAdelante(array){
    for(var i=0; i<array.length; i++){
        if(i == array.length - 1 ){
            array[i] = 0;
            continue;
        }
        
        array[i] = array[i+1];
    }

    return array;
}

var array = [1,2,3];
var newArray = moverAdelante(array);
console.log(newArray);

/**
 * Configura un array para que el resultado sean los valores en el orden contrario. 
 * Por ejemplo, returnReverso([1,2,3]) debe dar [3,2,1].
 */

function returnReverso(array){
    for(var i=0,  x=array.length-1; i<array.length/2; i++, x--){
      var aux = array[i];
      array[i] = array[x];
      array[x] = aux;
    }

    return array;
}

var array = [1,2,3];
var newArray = returnReverso(array);
console.log(newArray);


/**
 * Crea una función que cambie un array repitiendo sus valores originales (manteniendo el mismo orden).
 * Por ejemplo, repetirValores([4,”Ulysses”, 42, false]) debiera dar [4,4, “Ulysses”, “Ulysses”, 42, 42, false, false].
 */

function repetirValores(array){

    var arrayCopy = array.slice();
    for(var i=0, x=0; x < arrayCopy.length; i+=2, x++){
        array[i] = arrayCopy[x];
        array[i+1] = arrayCopy[x];
    }

    return array;
}

var array = [4,"Ulysses", 42, false];
var newArray = repetirValores(array);
console.log(newArray);






