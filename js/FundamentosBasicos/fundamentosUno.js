/**
 * Obtén del 1 al 255: Escribe una función que devuelve un array con todos los números del 1 al 255.
 */

function armarArray() {
    var array = [];
    for (var i = 1; i < 256; i++) {
        array.push(i);
    }

    return array;
}

console.log(armarArray());

/**
 * Consigue pares hasta 1000: 
 * Escribe una función que entregue la suma de todos los números pares del 1 al 1000 - 
 * Puedes usar un operador de módulo para este ejercicio. 
 */

function sumarPares() {
    var sum = 0;
    for (var i = 1; i < 1001; i++) {
        if (i % 2 === 0) {
            sum += i;
        }
    }

    return sum;
}

console.log(sumarPares());


/**
 * Suma impares hasta 5000: 
 * Escribe una función que devuelva la suma de todos los números impares entre 1 y 5000 (ej: 1+3+5+...+4997+4999).
 */

function sumarImpares() {
    var sum = 0;
    for (var i = 1; i < 5001; i++) {
        if (i % 2 === 1) {
            sum += i;
        }
    }

    return sum;
}

console.log(sumarImpares());


/** Itera un array: 
 * Escribe una función que devuelva la suma de todos los valores dentro de un array 
 * (ej:  [1,2,5] retorna 8. [-5,2,5,12] retorna 14). 
 */

function sumarArray(array) {
    var sum = 0;
    for (var i = 0; i < array.length; i++) {
        sum += array[i];
    }

    return sum;
}

var array = [-5, 2, 5, 12];
console.log(sumarArray(array));



/**
 * Encuentra el mayor (max): 
 * Dado un array con múltiples valores, escribe una función que devuelva el número mayor (ej: para [-3,3,5,7] el número mayor (max) es 7). 
 */

function mayor(array) {
    var mayor;
    for (var i = 0; i < array.length; i++) {
        if (i == 0) {
            mayor = array[i];
        }
        else if (mayor < array[i]) {
            mayor = array[i];
        }
    }

    return mayor;
}

var array = [-3, 3, 5, 7];
console.log(mayor(array));

/**
 * Encuentra el promedio (avg): 
 * Dado un array con múltiples valores, escribe una función que devuelva el promedio de los valores (ej: para [1,3,5,7,20] el promedio es 7.2).
 */

function avg(array) {
    var sum = 0;
    for (var i = 0; i < array.length; i++) {
        sum += array[i];
    }

    return sum / array.length;
}

var array = [1, 3, 5, 7, 20];
console.log(avg(array));

/**
 * Array de impares:
 * Escribe una función que devuelva un array de todos los números impares entre 1 y 50 (ej: [1,3,5, …, 47,49]).
 * Pista: Usa el método ‘push’.
 */

function impares(array) {
    var array = [];
    for (var i = 1; i < 50; i++) {
        if (i % 2 === 1) {
            array.push(i);
        }
    }

    return array;
}

console.log(impares());


/**
 * Mayor que Y: Dado un valor Y, escribe una función que toma un array y devuelve los valores mayores que Y. 
 * Por ejemplo, si arr = [1,3,5,7] y Y = 3, tu función devolverá 2 (hay 2 números en el array mayores que 3, esto son 5 y 7).
 */

function mayor(array, mayorQue) {
    var arrayMayores = [];
    for (var i = 0; i < array.length; i++) {
        if (mayorQue < array[i]) {
            arrayMayores.push(array[i]);
        }
    }

    return arrayMayores;
}

var mayorQue = 3;
var array = [1, 3, 5, 7];
console.log(mayor(array, mayorQue));



/**
 * Cuadrados: Dado un array con múltiples valores, 
 * escribe una función que reemplace cada valor por el cuadrado del mismo valor (ej: [1,5,10,-2] será [1,25,100,4]).
 */

function cuadrados(array) {
    for (var i = 0; i < array.length; i++) {
        array[i] = array[i] * array[i];
    }

    return array;
}

var array = [1, 5, 10, -2];
console.log(cuadrados(array));

/**
 * Negativos: Dado un array con múltiples valores, 
 * escribe una función que reemplace cualquier número negativo dentro del array por 0. 
 * Cuando el programa esté listo, el array no debiera contener números negativos (ej: [1,5,10,-2] se convertirá en [1,5,10,0]).
 */

function arraySinNegativos(array) {
    for (var i = 0; i < array.length; i++) {
        if (array[i] < 0) {
            array[i] = 0;
        }
    }

    return array;
}

var array = [1, 5, 10, -2];
console.log(arraySinNegativos(array));


/**
 * Max/Min/Avg: Dado un array con múltiples valores, 
 * escribe una función que devuelva un nuevo array que solo contenga el valor mayor (max), menor (min) y promedio (avg) del array original 
 * (ej: [1,5,10,-2] devolverá [10,-2,3.5]).
 */

function mayor(array) {
    var mayor;
    var menor;
    var sum = 0;
    for (var i = 0; i < array.length; i++) {
        sum += array[i];
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
    var newArray = [mayor, menor, sum / array.length];
    return newArray;
}

var array = [1, 5, 10, -2];
console.log(mayor(array));


/**
 * Intercambia Valores: Escribe una función que intercambie el primer y el último valor de cualquier array. 
 * La extensión mínima predeterminada del array es 2 (ej: [1,5,10,-2] será [-2,5,10,1]).
 */

function intercambio(array) {
    var aux;
    if (array.length > 1) {
        aux = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = aux;
    }

    return array;
}

var array = [1, 5, 10, -2];
console.log(intercambio(array));

/**
 * De Número a String: 
 * Escribe una función que tome un array de números y reemplace cualquier valor negativo por el string ‘Dojo’. 
 * Por ejemplo, dado el array = [-1,-3,2], tu función devolverá [‘Dojo’,‘Dojo’,2].
 */7


function a(x) {
    for (var i = 0; i < x.length; i++) {
        if (x[i] < 0) {
            x[i] = "Dojo";
        }
    }
    return x;
}

console.log(a([-1,-3,2]))