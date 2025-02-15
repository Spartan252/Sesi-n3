const express = require("express");
const router = express.Router();
const dataHandler = require('../controllers/data_handler.js');



router.route('/').post((req,res)=>{
        let obt = req.body;
        if(obt !== undefined){
            try{
                dataHandler.createProduct(obt);
            }
            catch(exception){
                const elemNec = ['title', 'description', 'imageURL', 'unit', 'stock', 'pricePerUnit', 'category'];
                const wNeeds = [];
                for(let need in elemNec){
                    if(!(obt.hasOwnProperty(elemNec[need]))){
                        wNeeds.push(elemNec[need]);
                    }
                }
                res.status(400).send("Le faltan los elementos: " + wNeeds.toString());
            }
            res.status(201).send("Producto creado con nombre: " + obt._title);
        }
        else{
            res.status(400).send("El body recibido es incorrecto");
        }
    });


router.route('/:id').put((req,res)=>{
    let obId = req.params.id;
    let newProd = dataHandler.getProductById(obId);
    let obt = req.body;
    if(newProd !== undefined){
        try{
            dataHandler.updateProduct(obId,obt);
        }
        catch(exception){
            const elemNec = ['_title', '_description', '_imageURL', '_unit', '_stock', '_pricePerUnit', '_category'];
            const wNeeds = [];
            for(let need in elemNec){
                if(!(obt.hasOwnProperty(elemNec[need]))){
                    wNeeds.push(elemNec[need]);
                }
            }
            res.status(400).send("Le faltan los elementos: " + wNeeds.toString());
        }
        res.status(200).send("Producto cambiado con nombre:: " + obt._title);
    }
    else{
        res.status(404).send("El id recibido es incorrecto o no existe: " + obId);
    }
});


router.route('/:id').delete((req,res)=>{
    let obId = req.params.id;
    let delProd = dataHandler.getProductById(obId);
    if(delProd !== undefined){
        try{
            dataHandler.deleteProduct(obId);
            res.status(200).send("Producto eliminado con nombre:: " + delProd._title);
        }
        catch (exception){
            res.status(404).send("ERROR");
        }
    }
    else{
        res.status(404).send("No se encontró producto con uuid: " + obId);
    }
});



module.exports = router;


