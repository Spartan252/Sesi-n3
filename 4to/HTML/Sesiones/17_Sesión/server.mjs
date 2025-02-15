import express from "express";
import chalk from "chalk";
import * as fs from 'node:fs';
import cors  from "cors";
import ascii_cats from 'ascii-cats';


const app = express();
const port = 3000;

app.use(cors({
    methods:  ['GET', 'POST', 'DELETE', 'UPDATE', 'PUT', 'PATCH']
}));


function print_cat (req, res, next) {
    console.log(ascii_cats());
    next();
}

function print_log (req, res, next) {
    console.log(chalk.blue("Método: "),chalk.green(req.method));
    console.log(chalk.blue("Ruta: "),chalk.green(req.originalUrl));
    console.log(chalk.blue("Fecha: "),chalk.green(new Date(Date.now()).toString()));
    console.log(chalk.blue("Content-type: "),chalk.green(req.get("Content-type")));
    next();
}

app.use(print_cat);

app.use("/users", print_log);

app.get("/", (req, res) => {
    console.log(chalk.blue("Entró a raíz"));
    res.send("Hola Mundo, Voy a sacarte la ip");
});

app.get("/home", (req, res) => {
    console.log(chalk.green("Entró a home"));
    res.send("Entró a la home");
});

app.get("/users", (req, res) => {


    let auth = req.get('x-auth');
    if(auth){
        console.log(chalk.yellow("Consultando usuarios"));
        fs.readFile('./users.json', 'utf8', function (error, data){
            if (error) {
                console.log("error");
            }
            console.log(chalk.green("MIRA USUARIOS"));
            console.table(JSON.parse(data));
            console.log(chalk.green("¡Usuarios Encontrados!"));
            res.send(data);
    
        });
    }
    else{
        console.log(chalk.red("No autorizado"));
        res.sendStatus(401);
    }

});


app.listen(port, () => {
    console.log("Aplicación de ejemplo corriendo en puerto " + port);
});
