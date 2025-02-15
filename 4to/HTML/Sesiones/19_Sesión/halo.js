
let header_1 = document.getElementById("hdr_1");

let contador = document.getElementById("cnt");

let button = document.getElementById("btn");

let button_1 = document.getElementById("btn_1");

let button_2 = document.getElementById("btn_2");

let num = 0;

let button_3 = document.getElementById("btn_3");

let input = document.getElementById("inpt");

button.addEventListener('click', function() {
    alert('Me clickeaste');
});


button_1.addEventListener('click', function() {
    hdr_1.innerHTML ++
    num++
    contador.innerHTML = "Contador: <b>"+ num +"<b>"
});


button_2.addEventListener('click', function() {
    hdr_1.innerHTML --
    num ++
    contador.innerHTML = "Contador: <b>"+ num +"<b>"
});

button_3.addEventListener('click', function() {
    alert('Enviado');
    input.value = ""
});

input.addEventListener('keypress', function() {
    if (event.key == "Enter"){
        button_3.click()
    }
});