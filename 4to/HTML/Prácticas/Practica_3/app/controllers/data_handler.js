const express = require('express');
const fs = require('fs')
const Product = require('./product');

const jsonContenido = fs.readFileSync('data/products.json','utf8')

const products = JSON.parse(jsonContenido);



//const products = [];
function getProducts()
{
    return products;
}

function getProductByUUID(uuid)
{
    return products.find(
        (Products) => Products._uuid === uuid);
}

function findProduct(query)
{
    let posibles = [];
    if(query !== undefined && typeof query === 'string')
    {
        query = query.split(':')
        if(query.length === 1) // significa que solo hay un titulo y no cateogira
        {
            for(let prod in products)
            {
                let temp = products[query]._title;
                if(temp.includes(query))
                {
                    posibles.push(products[prod])
                }
            }
        }
        else if(query.length === 2)
        {
            for(let prod in products)
            {
                let temp = products[query]._category;
                if(temp.includes(query))
                {
                    posibles.push(products[prod])
                }
            }
        }
        else
        {
            return 'No existe el articulo'
        }
    }
    return posibles;
}

function createProduct(product)
{
    products.push(Product.createFromObject(product));
    fs.writeFileSync('./data/products.json', JSON.stringify(products));
}


function updateProduct(uuid, updatedProduct)
{
    let busquedaIndi = getProductByUUID(uuid);
    if(busquedaIndi === -1 || busquedaIndi === undefined)
    {
        return undefined;
    }
    else
    {
        for (let temp in updatedProduct)
        {
            if (temp !== '_uuid')
            {
                //let busqueda = '_' + temp;
                let busqueda = temp;

                busquedaIndi[busqueda] = updatedProduct[temp];
            }
        }
    }
    fs.writeFileSync('./data/products.json', JSON.stringify(products));
    return busquedaIndi;
}


function deleteProduct(uuid)
{
    let busquedaIndi = getProducts().findIndex((Products) =>
        Products._uuid === uuid);
    if(busquedaIndi !== -1 || busquedaIndi !== undefined)
    {
        products.splice(busquedaIndi,1);
        fs.writeFileSync('./data/products.json', JSON.stringify(products));
    }
}



exports.getProducts = getProducts;
exports.getProductByUUID = getProductByUUID;
exports.createProduct = createProduct;
exports.updateProduct = updateProduct;
exports.deleteProduct = deleteProduct;
exports.findProduct = findProduct;
