const express = require('express');
const router = express.Router();

const { getProducts, findProducts, getProductById } = require('../controllers/data_handler');
const ShoppingCart = require('../controllers/shopping_cart');


router.get('/', (req, res) => {
    const products = getProducts();
    res.json(products);
});

router.get('/filter', (req, res) => {
    const { query } = req;
    const products = getProducts();
    const filteredProducts = findProducts(products, query);
    res.json(filteredProducts);
});

router.get('/:id', (req, res) => {
    const { id } = req.params;
    const product = getProductById(id);
    if (!product) {
        return res.status(404).json({ error: `No se encontró el producto con ID ${id}.` });
    }
    res.status(200).json(product);
});

const cart = new ShoppingCart();
router.post('/cart', (req, res) => {
    const { body } = req;

    if (!Array.isArray(body)) {
        return res.status(400).json({ error: "El cuerpo de la solicitud debe ser un arreglo." });
    }
    const productsInCart = [];

    for (const item of body) {
        const { id, quantity } = item;
        const product = getProductById(id);
        if (!product) {
            return res.status(404).json({ error: `No se encontró el producto con ID ${id}.` });
        }

        productsInCart.push({ product, quantity });
    }

    res.status(200).json(productsInCart);
});


module.exports = router;
