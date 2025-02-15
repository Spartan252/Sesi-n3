const mongoose = require('mongoose');

// Conexión con la BD y creación de modelo "Usuarios":
let mongoConnection = "mongodb+srv://admin:sejimeneza@myapp.rjkn4zf.mongodb.net/MyApp";
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
    edad: {
        type: Number,
        min: 18,
        max: 80,
        required: true
    },
        carrera: {
        type: String,
        enum:
        ['IE', 'ISC', 'IES', 'ISI'],
        required: true
    },
});

// Creamos el modelo (nombre, esquema)
let User = mongoose.model('users', userSchema);
// Información que va a tener nuestro nuevo registro 
let newUser = {nombre: "Dorx Tejeda", edad: 26, carrera: "IES"};
// A partir de la información y el modelo, hacemos un usuario 
let user = User(newUser);
// Guardamos el usuario en la BD (030, es asincrono) 
user.save().then((doc) => console.log("Usuario creado: " + doc));