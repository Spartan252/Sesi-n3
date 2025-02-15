import mongoose from'mongoose';
import express from'express';
import cors from'cors';

const app = express();
const port = 3000;
app.use(cors({
    methods: ['GET','POST','DELETE','UPDATE','PUT','PATCH']
}));
app.use(express.json());


app.listen(port, () => {
    console.log("Aplicación de ejemplo corriendo en puerto " + port);
});


// Conexión con la BD y creación de modelo "Usuarios":
let mongoConnection = "mongodb+srv://admin:sejimeneza@myapp.rjkn4zf.mongodb.net/MyAppDB";
let db = mongoose.connection;

db.on('connecting', () => {
    console.log('Conectando...');
    console.log(mongoose.connection.readyState); //State 2: Connecting
});

db.on('connected', () => {
    console.log('¡Conectado exitosamente!');
    console.log(mongoose.connection.readyState); //State 1: Connected
});

mongoose.connect(mongoConnection, {useNewUrlParser: true});

// Definimos el esquema:
let userSchema = mongoose.Schema({
    nombre: {
        type: String,
        required: true
    },
    correo: {
        type: String,
        required: true
    },
    password: {
        type: String,
        required: true
    },
    edad: {
        type: Number,
        min: 0,
        max: 120,
        required: true
    },
    sexo: {
        type: String,
        enum: ['H', 'M'],
        required: true
    }
});
// Creamos el modelo (nombre, esquema)
let User = mongoose.model('users', userSchema);

/*
// Información que va a tener nuestro nuevo registro 
let newUser = {name: "Dorx Tejeda", email: "dorx@gmail.com", password:"dorx", age: 26, gender: "H"};
// A partir de la información y el modelo, hacemos un usuario 
let user = User(newUser);
// Guardamos el usuario en la BD (030, es asincrono) 
user.save().then((doc) => console.log("Usuario creado: " + doc));
*/

app.post('/api/users', (req, res) => {
    console.log("Guardando usuario...");
    // Información que va a tener nuestro nuevo registro
    let newUser = {
        nombre: req.body.nombre,
        correo: req.body.correo,
        password: req.body.password,
        edad: req.body.edad,
        sexo: req.body.sexo
    };
    // A partir de la información y el modelo, hacemos un usuario 
    let user = User(newUser);
    // Guardamos el usuario en la BD
    user.save().then((doc) => {
        console.log("Usuario creado: " + doc);
        res.send('Usuario creado exitosamente: ' + doc);
    });
});

app.get('/api/users', (req, res) => {
    console.log("Consultando usuarios...");
    let nombre = req.query.nombre;

    User.find({
        nombre: {$regex: nombre},
        sexo: "M"
    }).then(function (docs) {
        res.send(docs);
        console.log(docs);
    }).catch((err) => console.log(err));
});

app.put('/api/users', (req, res) => {
    console.log("Actualizando información...");
    let id = req.body.id,
        nombre = req.body.nombre,
        object_to_update = {},
        flag_updated = false;
    
    if(nombre != undefined){
        object_to_update.nombre = nombre;
        flag_updated = true;
    }

    console.log(id);
    if(flag_updated){
        User.findByIdAndUpdate(id, object_to_update, {new: true}).then((doc) => {
            console.log("Usuario actualizado:");
            console.log(doc);
            res.send(doc);
        }).catch((err) => console.log(err));
    }
    else{
        res.send("No se ha actualizado");
    }
});

app.delete('/api/users', (req, res) => {
    console.log(chalk.blue("Eliminando registro..."));
    let id = req.body.id;

    User.findByIdAndDelete(id).then((doc) => {
        console.log("Usuario eliminado:");
        console.log(doc);
        res.send(doc);
    }).catch((err) => console.log(err));
});