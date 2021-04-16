function a() {
    console.log('hola');
}
console.log('Dojo');

/**
console

"Dojo"
**/

function b() {
    console.log('hola');
    return 15;
}
var x = b();
console.log('x es', x);

/**
var value
x   15

console
"hola"
"x es 15"

**/

function a(n) {
    console.log('n es', n);
    return n+15;
}
var x = a(3);
console.log('x es', x);

/**
var value
n = 3
x = 18

console
"n es 3"
"x es 18"
**/

var z = 15;
console.log(z);
function a(z){
   console.log(z);   
   return z;
}
var b = a(10);
console.log(b);
console.log(z);

/**
var value
z   15
b   10

console

15
10
10
15
*/

var c = 15;
console.log(c);
function d(c){
   console.log(c);   
   return c*2;
}
var e = d(10);
console.log(e);
console.log(c);

/**
var value
c   15
e  20

console
15
10
20
15
**/

function a(n) {
    console.log('n es', n);
    y = n*2;
    return y;
}
var x = a(3) + a(5);
console.log('x es', x);

/**
var value
x    6 + 10 -> 16

console
"n es 3"
"n es 5"
"x es 16"
*/

function x(num1, num2) {  
   return num1+num2;
}
console.log(x(2,3))
console.log(x(3,5))

/**
var value
num1 2 3
num2 3 5


console
5
8
*/

function y(num1, num2) {
   console.log(num1);   
   return num1+num2;
}
console.log(y(2,3))
console.log(y(3,5))

/**
var value
num1 2 3
num2 3 5

console
2
5
3
8
**/

function z(a,b) {
    var c = a + b;
    console.log('c es', c);
    return c;
}
var x = z(2,3) + z(3,5);
console.log('x es', x);

/**
var value
a   2 3
b   3 5
c   5 8
x   5+8

console
"c es 5"
"c es 8"
"x es 13"
**/

function d(a,b) {
    var c = a + b;
    console.log('c es', c);
    return c;
}
var x = d(2,3) + d(3,d(2,1)) + d(d(2,1),d(2,3));
console.log('x es', x);

/**
var value
a 2 2 3 2 2 3
b 3 1 3 1 3 5
c 5 3 6 3 5 8
x 5 + 6 + 8 

console
"c es 5"
"c es 3"
"c es 6"
"c es 3"
"c es 5"
"c es 8"
"x es 19"

**/