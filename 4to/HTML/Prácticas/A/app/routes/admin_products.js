const express = require('express');
const router = express.Router();
const { createProduct, getProductById, updateProduct, deleteProduct  } = require('../controllers/data_handler');


router.post('/', (req, res) => {
    const { uuid, title, description, imageUrl, unit, stock, pricePerUnit, category } = req.body;
    const requiredAttributes = ['uuid', 'title', 'description', 'imageUrl', 'unit', 'stock', 'pricePerUnit', 'category'];
    const missingAttributes = [];

    for (const attribute of requiredAttributes) {
        if (!(attribute in req.body)) {
            missingAttributes.push(attribute);
        }
    }

    if (missingAttributes.length > 0) {
        return res.status(400).json({ error: `Faltan los siguientes atributos en la solicitud: ${missingAttributes.join(', ')}` });
    }

    const newProduct = {
        uuid,
        title,
        description,
        imageUrl,
        unit,
        stock,
        pricePerUnit,
        category
    };

    if (createProduct(newProduct)) {
        res.status(201).json({ message: `Producto "${title}" creado correctamente.` });
    } else {
        res.status(500).json({ error: "Ocurrió un error al crear el producto." });
    }
});

router.put('/:id', (req, res) => {
    const uuid = req.params.uuid;
    const { title, description, imageUrl, unit, stock, pricePerUnit, category } = req.body;


    const existingProduct = getProductById(productId);
    if (!existingProduct) {
        return res.status(404).json({ error: `El producto con ID ${productId} no existe.` });
    }

    existingProduct.uuid = uuid;
    existingProduct.title = title;
    existingProduct.description = description;
    existingProduct.imageUrl = imageUrl;
    existingProduct.unit = unit;
    existingProduct.stock = stock;
    existingProduct.pricePerUnit = pricePerUnit;
    existingProduct.category = category;


    updateProduct(productId, existingProduct);


    res.status(200).json({ message: `El producto "${existingProduct.title}" ha sido actualizado.` });
});


router.delete('/:id', (req, res) => {
    const productId = req.params.uuid;

    const productToDelete = getProductById(productId);
    if (!productToDelete) {
        return res.status(404).json({ error: `El producto con ID ${productId} no existe.` });
    }

    const deleted = deleteProduct(productId);
    if (!deleted) {
        return res.status(500).json({ error: "Ocurrió un error al eliminar el producto." });
    }

    res.status(200).json({ message: `El producto "${productToDelete.title}" ha sido eliminado.` });
});



module.exports = router;
