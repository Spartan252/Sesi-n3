let url = "https://api.npoint.io/c9fba12a208f62932f78"

let datos = {var1:"hola", var2: "mundo"};
console.log("aaado: ");

function guardarEnJSON(datos,url){
    let xhr = new XMLHttpRequest();

    xhr.open("POST",url);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.send(JSON.stringify(datos));

    xhr.onload = function (){
        if (xhr.status != 200) {
            alert(xhr.status + ": " + xhr.statusText);
        } else{
            console.log("Guardado: ", xhr.responseText);
        }
    }
}