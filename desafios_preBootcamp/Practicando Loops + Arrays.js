var h = [2,4,6,8,10];
for (var i = 0; i < h.length; i++) {
    console.log(i);
    console.log(h[i]);
}
/**
var  value
i      0-1-2-3-4
h[0]   2
h[1]   4 
h[2]   6 
h[3]   8 
h[4]   10            


console
0
2
1
4
2
6
3
8
4
10
**/

var j = [2,4,6,8,10];
for (var k = j.length - 1; k > 0; k--) {
    console.log(k);
    console.log(j[k]);
}

/**
var value
k 4 3 2 1
j[4]
j[3]
j[2]
j[1]

console
4
10
3
8
2
6
1
4
**/

var m = [2,4,6,8,10];
for (var n = 0; n < m.length; n += 2) {
    console.log(n);
    console.log(m[n]);
}

/**
var value
n   0 2 4 
m[0] 2
m[2] 6

console
0
2
2
6
4
10
**/

var p = [-1,0,5,-3,2];
for (var q = 0; q < p.length; q++) {
    if (p[q] < 0) {
        p[q] = "Dojo";
    }
}
console.log(p);

/**
var  value
q    0 1 2 3 4
p[0] -1 "Dojo"
p[1] 0
p[2] 5
p[3] -3 "Dojo"
p[4] 2

console

["Dojo",0,5,"Dojo",2]
**/

var r = [-1,0,5,-3,2];
for (var s = 0; s < r.length; s++) {
    if (r[s] > 0) {
        r[s] = r[s] * r[s];
    }
}
console.log(r);

/**
var value
s    0 1 2 3 4
r[0] -1
r[1] 0
r[2] 5 25
r[3] -3 
r[4] 2 4

console

[-1,0,25,-3,4]
**/

var t = [];
for (var u = 0; u < 4; u++) {
    t.push(u);
}
console.log(t);

/**
var value
u   0 1 2 3
t  [0] [0,1] [0,1,2] [0,1,2,3]

console

[0,1,2,3]

**/

var v = [1,2,3,4,5];
for (var w = 0; w < v.length; w++) {
    v.pop();
}
console.log(v);

/**
var       value
w            0              1      2       3 
v.length     5              4      3       2  
v         [1,2,3,4,5] [1,2,3,4] [1,2,3]  [1,2] 


console
[1,2]

**/