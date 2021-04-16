for(var i=0; i<5;i++){   
   console.log(i);
}

/**
var value
i   0 1 2 3 4

console
0
1
2
3
4
*/

for(var i=0; i<5; i++)
{
   i = i + 1;  
   console.log(i);
}

/**
var value
i   0 1 - 2 3 - 4 5

console
1
3
5
*/

for(var i=0; i<5; i++)
{
   i = i + 3; 
   console.log(i);
}

/**
var value
i  0 3 - 4 7

console
3
7
*/

function y(num1, num2){   
   return num1+num2;
}
console.log(y(2,3))
console.log(y(3,5))

/**
var value
num1 2 3
num2 3 5

console
5
8
*/

function y(num1, num2){
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
*/

a = 15;
console.log(a);
function y(a){
   console.log(a);   
   return a;
}
b = y(10);
console.log(b);

/**
var value
a    15
a(f) 10
b    10

console
15
10
10
*/

a = 15;
console.log(a);
function y(a){
   console.log(a);   
   return a*2;
}
b = y(10);
console.log(b);

/**
var value
a    15
a(f) 10
b    20

console
15
10
20
*/