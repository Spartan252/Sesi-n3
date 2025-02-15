const express = require('express');
const router = require('./app/controllers/router');

const app = express();
const port = 3000;

app.use(express.json());
app.use(router);


app.use(express.static('app'));
app.use('/views', express.static('views'));


app.listen(port, () => {
    console.log("Aplicación corriendo en puerto " + port);

});