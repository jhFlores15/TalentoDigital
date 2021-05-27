/**
 * Tamaño Grande - Dado un array, 
 * escribe una función que cambie todos los números positivos en él, por el string “big”.
 */

 function a(x) {
    for (var i = 0; i < x.length; i++) {
        if (x[i] >= 0) {
            x[i] = "big";
        }
    }
    return x;
}

console.log(a([-1,-3,2]))

/**
 * Imprime (print) el menor, devuelve (return) el mayor - 
 * Crea una función que tome un array de números. La función debería imprimir (print) el menor valor del array, y devolver (return) el mayor. 
 */



 function numeros(array) {
    var mayor;
    var menor;
    for (var i = 0; i < array.length; i++) {
        if (i === 0) {
            mayor = array[i];
            menor = array[i];

        }
        else {
            if (mayor < array[i]) {
                mayor = array[i];
            }
            if (menor > array[i]) {
                menor = array[i];
            }
        }
    }

    console.log(menor);
    return mayor;
}

var array = [1, 5, 10, -2];
console.log(numeros(array));


/**
 * Imprime (print) uno, devuelve (return) otro- Crea una función para un array de números. 
 * La función debería imprimir (print) el penúltimo valor y devolver (return) el primer valor impar.
 */

 function random(array) {
    console.log(array[array.length - 2]);
    for (var i = 0; i < array.length; i++) {
        if(array[i] % 2 === 1){
            return array[i];
        }
    }

    return "no hay numeros Impares";
}

var array = [1, 5, 10, -2];
console.log(random(array));

/**
 * Doble Visión - Dado un array, 
 * crea una función que devuelva un nuevo array donde cada valor se duplique. 
 * Entonces, doble([1,2,3]) debiera devolver [2, 4, 6] sin cambiar el array original.
 */

 function doblarArray(array) {
    var arrayDoble = [];
    for (var i = 0; i < array.length; i++) {
        arrayDoble.push(array[i]*2);
    }

    return arrayDoble;
}

var array = [1, 5, 10, -2];
console.log(doblarArray(array));


/**
 * Contar Positivos -  Dado un array de números, 
 * crea una función para reemplazar el último valor con el número de valores positivos encontrados en el array. 
 * Ejemplo, contarPositivos([-1,1,1,1]) cambia el array original y devuelve [-1,1,1,3].
 */


 function contarPositivos(array) {
    var sum = 0;
    for (var i = 0; i < array.length; i++) {           
        if(array[i] >= 0){
            sum += array[i];
        }
    }

    array[array.length - 1] = sum;
    return array;
}

var array = [1, 5, 10, -2];
console.log(contarPositivos(array));

/**
 * Pares e Impares - Crea una función que acepte un array. 
 * Cada vez que ese array tenga 3 valores impares seguidos, imprime (print) “¡Qué imparcial!”, 
 * y cada vez que tenga 3 pares seguidos, imprime (print) “¡Es para bien!”.
 */

 function paresImpares(array) {
    var hayTresPares   = true;
    var hayTresimpares = true;
    var indiceLimite= array.length - 3;
    
    for (var i = 0; i < array.length; i++) {  
        var cont = 0;
      
       if(i <= indiceLimite){
         while(cont < 3){
            if(array[i+cont] %2 === 0){
                hayTresimpares = false;
            }
            else{
                hayTresPares = false;
            }
          
            if(cont == 2){
                if(hayTresimpares){
                    console.log("¡Qué imparcial!");
                }
                if(hayTresPares){
                    console.log("¡Es para bien!");
                }
              hayTresPares   = true;
              hayTresimpares = true;
            }
          cont++;
        }
       }
    }
}

var array = [1, 5,3,2,4,6,8,7,3,1 ];
paresImpares(array);



/**
 * Incrementa los Segundos - 
 * Dado un array de números arr, agrega 1 a cualquier otro elemento, 
 * específicamente a aquellos cuyo índice es impar (arr[1], arr[3], arr[5], etc). 
 * Luego, console.log cada valor del array y devuelve arr. 
 */

function random(array) {
    for (var i = 0; i < array.length; i++) {           
        if(i%2 == 1){
            array[i] = array[i]+1;
        }
        console.log(array[i]);
    }

    return array;
}

var array = [1, 5, 10, -2];
console.log(random(array));

/**
 * Longitudes previas - 
 * Pasado un array (similar a decir ‘tomado un array’ o ‘dado un array’) que contiene strings, 
 * reemplaza cada string con un número de acuerdo cantidad de letras (longitud) del string anterior. 
 * Por ejemplo, longitudesPrevias([“programar”,“dojo”, “genial”]) debería devolver [“programar”,9, 4]. 
 * Pista: ¿For loops solo puede ir hacia adelante?
 */

function longitudesPrevias(array) {
    for (var i = array.length-1; i > 0; i--) {           
       var length = array[i-1].length;
       array[i] = length;
    }

    return array;
}

var array = ["programar", "dojo", "genial"];
console.log(longitudesPrevias(array));

/**
 * Agrega Siete - Construye una función que acepte un array. 
 * Devuelve un nuevo array con todos los valores del original, pero sumando 7 a cada uno. No alteres el array original. 
 * Por ejemplo, agregaSiete([1,2,3) debería devolver [8,9,10] en un nuevo array. 
 */

function agregaSiete(array) {
    var newArray = [];
    for (var i = 0; i < array.length; i++) {           
       newArray.push(array[i] + 7);
    }

    return newArray;
}

var array = [1,2,3];
console.log(agregaSiete(array));

/**
 * Array Inverso - Dado un array, 
 * escribe una función que invierte sus valores en el lugar. 
 * Ejemplo: invertir([3,1,6,4,2)) devuelve el mismo array pero con sus valores al revés, 
 * es decir [2,4,6,1,3]. Haz esto sin crear un array temporal vacío. (Pista: necesitarás intercambiar (swap) valores).
 */

function returnReverso(array){
    for(var i=0,  x=array.length-1; i<array.length/2; i++, x--){
      var aux = array[i];
      array[i] = array[x];
      array[x] = aux;
    }

    return array;
}

var array = [3,1,6,4,2];
var newArray = returnReverso(array);
console.log(newArray);

/**
 * Perspectiva: Negativa - Dado un array crear y devuelve uno nuevo que contenga todos los valores del array original, 
 * pero negativos (no simplemente multiplicando por -1). Dado [1,-3,5], devuelve [-1,-3,-5].
 */

 function negativos(array) {
    var newArray = [];
    for (var i = 0; i < array.length; i++) {           
       if(array[i] > 0){
        newArray.push(array[i]*-1);
       }
       else{
        newArray.push(array[i]);
       }
    }

    return newArray;
}

var array = [1,2,-3,10];
console.log(negativos(array));



/**
 * Siempre hambriento - Crea una función que acepte un array e imprima (print) “yummy” cada vez que alguno de los valores sea “comida”. 
 * Si ningún valor es “comida”, entonces imprime “tengo hambre” una vez. 
 */

function yummy(array) {
    var hayComida = false;
    for (var i = 0; i < array.length; i++) {           
      if(array[i] == "comida"){
        hayComida = true;
        console.log("yummy");
      }
    }

    if(hayComida == false){
        console.log("tengo hambre");
    }
}

var array = [1,2,-3,"comida"];
yummy(array);


/**
 * Cambiar hacia el centro -  
 * Dado un array, cambia el primer y último valor, el tercero con el ante penútimo, etc. 
 * Ejemplo: cambiaHaciaElCentro([true, 42, “Ada”, 2, “pizza”]) cambia el array a [“pizza¨, 42, “Ada”, 2, true]. 
 * cambiaHaciaElCentro([1,2,3,4,5,6]) cambia el array a [6,2,4,3,5,1]. No es necesario devolver (return) el array esta vez. 
 */

 function returnReverso(array){
    for(var i=0, x=array.length-1; i<array.length/2; i+=2, x-=2){
      var aux = array[i];
      array[i] = array[x];
      array[x] = aux;
    }

    return array;
}

var array = [true, 42, "Ada", 2, "pizza"];
var newArray = returnReverso(array);
console.log(newArray);


/**
 * Escala el Array -
 * Dado un array arr y un número num, 
 * multiplica todos los valores en el array arr por el número num, y devuelve el array arr modificado. 
 * Por ejemplo, escalaArray([1,2,3], 3] debería devolver [3,6,9].
 */

function multiplicarArray(array,num) {
    for (var i = 0; i < array.length; i++) {
        array[i] = array[i]*num;
    }

    return array;
}

var array = [1,2,3];
var num = 3;
console.log(multiplicarArray(array,num));


