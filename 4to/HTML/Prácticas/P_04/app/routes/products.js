const express = require("express");
const router = express.Router();
const dataHandler = require('../controllers/data_handler.js');


router.route('/').get((req,res) =>{
    let ret;
    if(req.query.filter === undefined){
        ret = dataHandler.getProducts(req.query.offset, req.query.limit);
        res.status(200).json(ret)
    }
    else{
        ret = dataHandler.findProducts(req.query.filter)
        res.status(200).json(ret)
    }
});


router.route('/cart').post((req, res) =>{
    let elems = req.body;

    if (!Array.isArray(elems)){
        res.status(400).send("El body debe de ser un arreglo");
        return;
    }
    let prodToTemp = [];

    for (let elem of elems){
        let newProd, prodU = elem._uuid;
        let cantidad = parseInt(elem.cantidad);
        newProd = dataHandler.getProductById(prodU);

        if (newProd !== undefined){
            prodToTemp.push({
                producto: newProd,
                cantidad: cantidad
            });
        }
        else{
            res.status(404).send("No hay producto con el uuid: " + prodU);
            return;
        }
    }
    res.status(200).json(prodToTemp);
});


router.route('/:id').get((req,res) =>{
    let obId = req.params.id;
    let newProd = dataHandler.getProductById(obId);
    if(newProd === undefined){
        res.status(404).send("No se encontró producto con uuid: " + obId);
    }
    else{
        res.status(200).json(newProd);
    }
});


module.exports = router;


