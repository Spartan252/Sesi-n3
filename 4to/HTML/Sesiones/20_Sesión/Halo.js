
function getInfo(elemento, atributo) {
    console.log("ID: " + elemento.id);
    console.log(elemento.attributes);
    console.log("¿Existe " + atributo + "?");
    console.log(elemento.hasAttribute(atributo));
}

function setInfo(elemento, atributo, valor) {
    elemento.setAttribute(atributo, valor);
    console.log("Atributo agregado");
    console.log(elemento);
}

function doStuff(){
    let lista = document.getElementById("lista"), 
        parrafo_1 = document.createElement("p"),
        parrafo_2 = document.createElement("p"),
        list_element_1 = document.createElement("li"),
        list_element_2 = document.createElement("li"),
        list_element_3 = document.createElement("li"),
        html_to_insert = "<mark>Importante</mark>";

    parrafo_1.innerText = "Párrafo 1";
    parrafo_2.innerText = "Párrafo 2";
    list_element_1.innerText = "1";
    list_element_2.InnerText = "2";
    list_element_3.InnerText = "3";
    lista.before(parrafo_1);
    lista.after(parrafo_2);
    lista.prepend(list_element_1);
    lista.insertBefore(list_element_2, lista.children[2]);
    lista.append(list_element_3);
    lista.insertAdjacentHTML('beforebegin', html_to_insert)


}