const express = require("express");
const router = express.Router();
const dataHandler = require('../controllers/data_handler.js');


// POST /admin/products

router.route('/').post((req,res)=>
{
        let obt = req.body;
        if(obt !== undefined)
        {
            try
            {
                dataHandler.createProduct(obt);
            }
            catch(exception)
            {
                const elemNec = ['title', 'description', 'imageURL', 'unit', 'stock', 'priceUnit', 'category'];
                const wNeeds = [];
                for(let need in elemNec)
                {
                    if(!(obt.hasOwnProperty(elemNec[need])))
                    {
                        wNeeds.push(elemNec[need]);
                    }
                }
                res.status(400).send("Al body le falta: " + wNeeds.toString());
            }
            res.status(201).send("Se creo el producto con nombre: " + obt._title);
        }
        else
        {
            res.status(400).send("El body recibido es incorrecto");
        }

    });

// =========================================

// PUT /admin/products/:id


router.route('/:id').put((req,res)=>
{
    let obId = req.params.id;
    let newProd = dataHandler.getProductByUUID(obId);
    let obt = req.body;
    if(newProd !== undefined)
    {
        try
        {
            dataHandler.updateProduct(obId,obt);
        }
        catch(exception)
        {
            const elemNec = ['_title', '_description', '_imageURL', '_unit', '_stock', '_priceUnit', '_category'];
            const wNeeds = [];
            for(let need in elemNec)
            {
                if(!(obt.hasOwnProperty(elemNec[need])))
                {
                    wNeeds.push(elemNec[need]);
                }
            }
            res.status(400).send("Al body le falta: " + wNeeds.toString());
        }
        res.status(200).send("Se cambio el producto con nombre: " + obt._title);
    }
    else
    {
        res.status(404).send("El id recibido es incorrecto o no existe: " + obId);
    }

});


// =========================================

// DELETE /admin/products/:id

router.route('/:id').delete((req,res)=>
{
    let obId = req.params.id;
    let delProd = dataHandler.getProductByUUID(obId);
    if(delProd !== undefined)
    {
        try
        {
            dataHandler.deleteProduct(obId);
            res.status(200).send("Se ha eliminado el producto con el nombre: " + delProd._title);
        }
        catch (exception)
        {
            res.status(404).send("Si ves este error no se que esta pasando");
        }
    }
    else
    {
        res.status(404).send("No existe algun producto con el siguiente id: " + obId);
    }
});








module.exports = router;


