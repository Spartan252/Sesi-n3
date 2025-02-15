// URL de un JSON generado (cada quien tiene una)
let url = "https://api.npoint.io/e8f98e9224bb5595ff5dTEST";
let datos = {var1: "Hola", var2: "Mundo"};
datos.lenght;

// Reemplaza el anterior archivo JSON por el nuevo​
function guardarEnJSON(datos, urlJSON) {
    // 1. Crear XMLHttpRequest object​
    let xhr = new XMLHttpRequest();
    // 2. Configurar:  POST actualizar archivo​
    /*  
        NOTA: Recuerda, para reemplazar como ahora, debe ser
        con "PUT", pero el servicio "npoint.io" para
        este ejemplo sólo permite con "POST" 
    */
    xhr.open('POST', urlJSON);
    // 3. Indicar tipo de datos JSON​
    xhr.setRequestHeader('Content-Type', 'application/json');
    // 4. Enviar solicitud al servidor
    xhr.send([JSON.stringify(datos)]); // Hacemos "datos" como JSON
    // 5. Una vez recibida la respuesta del servidor​
    xhr.onload = function () {
        if (xhr.status != 200) { // Analizar el estatus de la respuesta HTTP ​
            // Ocurrió un error
            alert(xhr.status + ': ' + xhr.statusText); // Ej. 404: Not Found​
        } else {
            console.log("Guardado:", xhr.responseText); // Significa que fue exitoso​
        }
    };
}

// Ejercicio 1:
// Punto 1:
function ej1_pt1() {
    let llamada = new XMLHttpRequest();
    llamada.open('GET', "https://jsonplaceholder.typicode.com/users");
    llamada.send();
    llamada.onload = function () {
        if (llamada.status != 200) {
            alert(llamada.status + ': ' + llamada.statusText);
        } else {
            console.log("Usuarios: ");
            console.table(JSON.parse(llamada.responseText)); 
        }
    }
}

// Punto 2:
function ej1_pt2(id) {
    let llamada = new XMLHttpRequest();
    llamada.open('GET', "https://jsonplaceholder.typicode.com/users/" + id);
    llamada.send();
    llamada.onload = function () {
        if (llamada.status == 404) {
            alert("Usuario no encontrado");
        } 
        else if (llamada.status != 200) {
            alert(llamada.status + ': ' + llamada.statusText);
        }
        else {
            console.log("Usuarios encontrado!");
            let usuario = JSON.parse(llamada.responseText);
            let to_print = "<b>Usuario: </b>" + usuario.name + 
                            '<br> <b>Correo: </b>' + usuario.email;
            // Recuerda tener un "div" con el id=test
            document.getElementById("test").innerHTML = to_print; 
        }
    }
}