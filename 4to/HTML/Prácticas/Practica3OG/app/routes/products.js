const express = require("express");
const router = express.Router();
const dataHandler = require('../controllers/data_handler.js');

// /products

router.route('/').get((req,res) =>
{
    let ret;
    if(req.query.filter === undefined)
    {
        ret = dataHandler.getProducts();
        res.status(200).json(ret)
    }
    else
    {
        ret = dataHandler.findProduct(req.query.filter)
        res.status(200).json(ret)
    }
});


// =======================================================

// /products/cart

router.route('/cart').post((req, res) =>
{
    let elems = req.body;

    if (!Array.isArray(elems))
    {
        res.status(400).send("El body tiene ser un arreglo a fuerzas");
        //Aqui sucede lo mismo donde tengo que mandar un return por que si no luego intenta mandar otro res
        return;
    }
    let prodToTemp = [];

    for (let elem of elems)
    {
        let newProd, prodU = elem._uuid;
        let cantidad = parseInt(elem.cantidad);
        newProd = dataHandler.getProductByUUID(prodU);

        if (newProd !== undefined)
        {
            // Agregar el producto con la cantidad al carrito
            prodToTemp.push({
                producto: newProd,
                cantidad: cantidad
            });
        }
        else
        {
            res.status(404).send("No hay ningun producto que tenga este UUDI: " + prodU);
             // La causa de este return es por que si no causa problemas al mandar despues otro res.
            return;
        }
    }

    res.status(200).json(prodToTemp);
});


// =======================================================
// /products/id

router.route('/:id').get((req,res) =>
{
    let obId = req.params.id;
    let newProd = dataHandler.getProductByUUID(obId);
    if(newProd === undefined)
    {
        res.status(404).send("El producto buscado con el uuid no se encontro: " + obId);

    }
    else
    {
        res.status(200).json(newProd);
    }
});


module.exports = router;


