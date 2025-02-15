
let url = "http://localhost:3000/users"

function readUsers(con_auth){
    console.log(con_auth);

    let xhr = new XMLHttpRequest();
    xhr.open("GET",url);
    if (con_auth)
        xhr.setRequestHeader("x-auth", "PASS123");
    else
        xhr.setRequestHeader("x-auth", "");
    xhr.send();
    xhr.onload = function (){
        if (xhr.status != 200) {
            alert(xhr.status + ": " + xhr.statusText);
        } else{
            console.log("Los usuarios: ");
            console.table(JSON.parse(xhr.responseText));
            alert("Los usuarios fueron leídos");
        }
    }

}