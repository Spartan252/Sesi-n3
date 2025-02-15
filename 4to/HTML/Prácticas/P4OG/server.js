
const express = require('express');
const router = require('./app/controllers/router');

const app = express();
const port = 3000;

app.use(express.json());
app.use(router);


app.use(express.static('app'));
app.use('/views', express.static('views'));


/*
app.get("/", (req, res) => {
        console.log("e-commerce app práctica 3");
    res.send("Hola Mundo, una práctica");
});
*/

app.listen(port, () => {
    console.log("Aplicación de ejemplo corriendo en puerto " + port);
});