
const express = require('express');
const path = require('path');

const productRouter = require('../routes/products.js');
const adminProductRouter = require('../routes/admin_products.js');

const router = express.Router();

router.use('/products', productRouter);
router.use('/admin/products', validateAdmin, adminProductRouter);

router.get('/', (req, res) => res.sendFile(path.resolve(__dirname + "/../views/home.html")));
router.get('/home', (req, res) => res.sendFile(path.resolve(__dirname + "/../views/home.html")));
router.get('/shopping_cart', (req, res) => res.sendFile(path.resolve(__dirname + "/../views/shopping_cart.html")));
router.get('/about_us', (req, res) => res.sendFile(path.resolve(__dirname + "/../views/about_us.html")));
router.get('/cat_A', (req, res) => res.sendFile(path.resolve(__dirname + "/../views/cat_A.html")));
router.get('/cat_B', (req, res) => res.sendFile(path.resolve(__dirname + "/../views/cat_B.html")));

function validateAdmin (req, res, next){
    let auth = req.get('x-auth');
    if(auth === "admin"){ 
        console.log("Accediendo");
        next();
    }
    else{
        console.log("Acceso no autorizado, no se cuenta con privilegios de administrado");
        res.sendStatus(403);
    }

};

module.exports = router;
