
let users = [
    {name: "Michael", age:37}, 
    {name: "John", age:30}, 
    {name: "David", age:27}
];

/**
 * ¿Cómo harías print/log de la edad de John?
 * ¿Cómo harías print/log del nombre del primer objeto?
 * ¿Cómo harías print/log del nombre y la edad de cada usuario utilizando un for loop? Tu output debería verse algo como esto
 * ¿Cómo harías para imprimir el nombre de los mayores de edad?
 */

 console.log(users[1].age);
 console.log(users[0].name);

for(var i = 0; i < users.length; i++){
    console.log(users[i].name+" - "+users[i].age);
}

for(var i = 0; i < users.length; i++){
    if(users[i].age >= 18){
        console.log(users[i].name);
    }
}
