const express = require('express');
// this one
const path = require('path');
const productRouter = require('../../routes/products.js');
const adminProductRouter = require('../../routes/admin_products.js');

const router = express.Router();

router.use('/products',productRouter);
router.use('/admin/products',validateAdmin,adminProductRouter);

function validateAdmin(req,res,next)
{
    let passAdminEnter = req.get('x-auth');
    if(passAdminEnter === 'admin')
    {
        next();
    }
    else
    {
        res.status(403).send("Acceso no autorizado, no se cuenta con privilegios de administrador");
    }

}


router.get('/', (req,res) =>
{
    res.sendFile(path.resolve(__dirname + "../../../views/P01_index.html"))
});

router.get('/home', (req,res) =>
{
    res.sendFile(path.resolve(__dirname + "../../../views/P01_index.html"))
});

router.get('/shopping_cart', (req,res) =>
{
    res.sendFile(path.resolve(__dirname + "../../../views/P01_cart.html"))
});



module.exports = router;