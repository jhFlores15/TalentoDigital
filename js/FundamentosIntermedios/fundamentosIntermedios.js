/**
 * Sigma - Implementa una función sigma(num) que, dado un número, devuelve la suma de todos los enteros positivos (incluyendo el número dado). Ej: sigma(3) = 6 (1+2+3); sigma(5) = 15 (1+2+3+4+5).
 */

function sigma(num) {
    var sum = 0;
    for (var i = 1; i <= num; i++) {
        sum += i;
    }

    return sum;
}

console.log(sigma(3));


/**
 * Factorial - Escribe una función factorial(num) que, 
 * dado un número, devuelva el producto (multiplicación) de todos los enteros positivos (incluyendo el número dado). 
 * Por ejemplo: factorial(3) = 6 (1*2*3); factorial(5) = 120 (1*2*3*4*5).
 */

function factorial(num) {
    var fact = 1;
    for (var i = 1; i <= num; i++) {
        fact = fact * i;
    }

    return fact;
}

console.log(factorial(5));


/**
 * Fibonacci - Crea una función para generar números de Fibonacci. 
 * En esta famosa secuencia matemática, cada número es la suma de las dos anteriores, 
 * partiendo con los valores 0 y 1. Tu función debería aceptar un argumento, 
 * un índice en la secuencia (donde 0 corresponde al valor inicial, 4 corresponden al valor cuatro más tarde, etc). 
 * Ejemplos: fibonacci(0) = 0 (dado), fibonacci(1) = 1 (dado), fibonacci(2) = 1 (fib(0)+fib(1), o 0+1), fibonacci(3) = 2 (fib(1) + fib(2)3, o 1+1), 
 * fibonacci(4) = 3 (1+2), fibonacci(5) = 5 (2+3), fibonacci(6) = 8 (3+5), fibonacci(7) = 13 (5+8). 
 * Haz esto primero sin usar recursión. 
 * Si no sabes qué es una recursión, no te preocupes puesto que vamos a introducir este concepto en la Parte 2 de esta actividad. 
 */


 function fibonacci(num){
    num1 = 0;
    num2 = 1;
	
	if(num == 0 || num == 1){
		return num;
	}
  
      for(var i=0;i<num-1;i++){
         num3 = num1+num2;
         num1 = num2;
         num2 = num3;
      }
    
    return num3;
    
  }
  
  console.log(fibonacci(3));
  


/**
 * Array: Penúltimo: Devuelve el penúltimo elemento del array. Dado [42,true,4,”Liam”, 7] devuelve “Liam”. Si el array es muy pequeño, devuelve null.   
 */

 function penultimo(array) {
    if (array.length < 2) {
        return null;
    }
    else{
        return array[array.length - 2];
    }

}

var array = [42, true, 4, "Liam", 7];
console.log(penultimo(array));




/**
 * Array: “N” último: Devuelve el elemento “N” último. Dado ([5,2,3,6,4,9,7],3], devuelve 6. Si el array es muy pequeño, devuelve null. 
 */

 function ultimo(array,num) {
    if(array.length <= num){
        return null;
    }
    return array[num];
}

var array = [5,2,3,6];
var num = 3
console.log(ultimo(array,num));

/**
 * Array: Segundo más grande: Devuelve el segundo elemento más grande de un array. Dado [42,1,4,3.14,7], devuelve 7.  Si el array es muy pequeño, devuelve null.
 */


function segundoMayor(array) {
    if(array.length < 2){
        return null;
    }

    array.sort((a, b) => a - b);
    return array[array.length - 2];
}

var array = [42,1,4,3.14,7];
console.log(segundoMayor(array));


/**
 * Doble Problema Par: 
 * Crea una función que cambie un array dado duplicando cada uno de sus elementos en una posición par, y manteniendo el orden original. 
 * Convierte [4, "Ulysses", 42, false]   a    [4,4, "Ulysses", "Ulysses", 42, 42, false, false].
 */

function repetirValores(array) {

    var arrayCopy = array.slice();
    for (var i = 0, x = 0; x < arrayCopy.length; i += 2, x++) {
        array[i] = arrayCopy[x];
        array[i + 1] = arrayCopy[x];
    }

    return array;
}

var array = [4, "Ulysses", 42, false];
var newArray = repetirValores(array);
console.log(newArray);
