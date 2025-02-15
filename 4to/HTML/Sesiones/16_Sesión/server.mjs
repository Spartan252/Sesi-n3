import express from "express";
import chalk from "chalk";
import * as fs from 'node:fs';

const app = express();
const port = 3000;

app.get("/", (req, res) => {
    console.log(chalk.blue("Entró a raíz"));
    res.send("Hola Mundo, Voy a sacarte la ip");
});

app.get("/home", (req, res) => {
    console.log(chalk.green("Entró a home"));
    res.send("Entró a la home");
});

app.get("/users", (req, res) => {
    console.log(chalk.yellow("Consultando usuarios"));

    let fileReadedCB = function (error, data){
        if (error) {
            console.log("error")
        }
        console.log("MIRA USUARIOS")
        console.table(JSON.parse(data));
        console.log(chalk.green("¡Usuarios Encontrados!"));
        res.send("Entró a la users, consultando usuarios");

    }
    fs.readFile('./users.json', 'utf8', fileReadedCB);

});


app.listen(port, () => {
    console.log("Aplicación de ejemplo corriendo en puerto " + port);
});





