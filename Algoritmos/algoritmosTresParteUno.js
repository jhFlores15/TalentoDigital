function a(x,y){
    return 5;
}
console.log(a(5,5))

/**
var value
a(x) 5
a(y) 5

console
5
*/

function a(x,y){
    z = []
    z.push(x);
    z.push(y);
    z.push(5);
    console.log(z);
    return z;
}
b = a(2,2)
console.log(b);
console.log(a(6,8));

/**
var value
a(x) 2
a(y) 2
f(z) [2,2 5]
b [2,2 5]    

console
[2,2 5]
[2,2 5]
[6,8,5]
[6,8,5]
*/

function a(x){
    z = [];
    z.push(x);
    z.pop();
    z.push(x);
    z.push(x);
    return z;
 }
 y = a(2);
 y.push(5);
 console.log(y);

/**
var value
a(x) 2
f(z) [2,2]
y [2,2] [2,2,5]   

console
[2,2 5]
*/

function a(x){
    if(x[0] < x[1]) {
       return true;
    }
    else {
       return false;
    }
 }
 b = a([2,3,4,5])
 console.log(b);

/**
var value
a(x) [2,3,4,5]
b true

console
true
*/

function a(x){
    for(var i=0; i<x.length; i++){
      if(x[i] > 0){
           x[i] = "Coding";
      }
    }
    return x;
}
console.log(a([1,2,3,4]))

/**
var value
a(x) [1,2,3,4]
a(i) 0 1 2 3
a(x) ["Coding", "Coding", "Coding", "Coding"]

console
["Coding", "Coding", "Coding", "Coding"]
*/

function a(x){
    for(var i=0; i<x.length; i++){
      if(x[i] > 5){
           x[i] = "Coding";
      }
      else if(x[i] < 0){
           x[i] = "Dojo";
      }
    }
    return x;
}
console.log(a([5,7,-1,4]))

/**
var value
a(x) [5,7,-1,4]
a(x) [5,"Coding","Dojo",4]


console
[5,"Coding","Dojo",4]
*/

function a(x){
    if(x[0] > x[1]) {
     return x[1];
    }
    return 10;
 }
 b = a([5,10])
 console.log(b);

 /**
var value
a(x) [5,10]
b 10


console
10
*/

function sum(x){
    sum = 0;
    for(var i=0; i<x.length; i++){
       sum = sum + x[i];
       console.log(sum);
    }
    return sum;
}

/**
no hace nada porque la funcion nunca fue llamada
var value


console

*/




