function multiply(x,y) {
    console.log(x);
    console.log(y);
}
b = multiply(2,3);
console.log(b);

/**
var value
x  2
y  3
b undefined

console
2
3
undefined
*/

function multiply(x,y) {
    return x*y;
}
b = multiply(2,3);
console.log(b);
console.log(multiply(5,2));

/**
var value
x  2
y  3
b 6

console
6
10
*/

var x = [1,2,3,4,5,10];
for(var i=0; i<5; i++) {
   i = i + 3; 
   console.log(i);
}

/**
var value
x  [1,2,3,4,5,10]
i  0 3 4

console
3
7
*/

var x=15;
console.log(x);
function awesome(){
    var x=10;
    console.log(x);
}
console.log(x);
awesome();
console.log(x);

/**
var value
x  15
x(f)  10

console
15
15
10
15
*/

for(var i=0; i<15; i+=2) {
    console.log(i);
 }

 /**
var value
i 0 2 4 6 8 10 12 14

console
0
2
4
6
8
10
12
14
*/

for(var i=0; i<3; i++) {
    for(var j=0; j<2; j++) {  
        console.log(i*j);
    }
 }

/**
var value
i 0 1 2
j(l) 0 1 - 0 1 - 0 1

console
0 
0
0
1
0
2

*/

function looping(x,y) {
    for(var i=0; i<x; i++) {
       for(var j=0; j<x; j++) {     
           console.log(i*j);
       } 
    }
 }
 z = looping(3,3);
 console.log(z);

/**
var value

console
0 
0
0
0
2
0
2
4
undefined

*/

function looping(x,y) {
    for(var i=0; i<x; i++) {
       for(var j=0; j<y; j++) {    
          console.log(i*j);
       } 
    }
    return x*y;
 }
 z = looping(3,5);
 console.log(z);

 
/**
var value

console
0
0
0
0
0
0
1
2
3
4
0
2
4
6
8
15

*/