// Prueba 1:
/*
console.log('uno');
setTimeout(function timeout(){
    console.log('A');
}, 7000);
setTimeout(function timeout(){
    console.log('B');
}, 0);
setTimeout(function timeout(){
    console.log('C');
}, 2000);
setTimeout(function timeout(){
    console.log('D');
}, 1000);
console.log('end');
*/

// Ejercicio 1:​

for (let i = 0; i < 5; i++) {
    setTimeout(function timeout() {
        console.log("Hola ");
    }, i*1000);
}
for (let j = 0; j < 4; j++){
    setTimeout(function timeout() {
        console.log("mundo");
    }, j*1000);
}


// Promesas:

let promesa1 = new Promise(function(reslolve, reject){
    setTimeout(()=>{
        if(Math.random() < 0.5){
            console.log("Procesando la promesa");
            reslolve("Correcto!");
        }
        else{
            reject(new Error("Algo falló"));
        }
    });
});
promesa1.then(function(result){
    console.log(result);
},
function rechazo(error){
    console.log(error);
});

async function loadJson(url) { 
    let response = await fetch(url); 
    if (response.status == 200) {
        let json = await response.json(); 
        return json;
    }
    console.log(response.status);
    throw new Error(response.status);
}
loadJson('user.json').catch(alert);
