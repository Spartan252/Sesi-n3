
const fs = require('fs');


function getProducts(){
  return JSON.parse(fs.readFileSync("./app/data/products.json", "utf8"));
}

function getProductById(uuid){
  let products= getProducts();
  for (let item in products ){
      if (products[item].uuid==uuid) return products[item];
  }
  return null;
}

function createProduct(product){
  let products= getProducts();
  for (let item in products){
      if (product.uuid==products[item].uuid) return false;
  }
  products.push(product);
  fs.writeFileSync("./app/data/products.json",JSON.stringify(products),"utf8")
  console.log(products);
  return true;
}

function updateProduct(uuid, updatedProduct){
  let products= getProducts()
  let product=products.find(oldproduct =>oldproduct.uuid == updatedProduct.uuid)
  if (product == null) createProduct(updatedProduct);
  product.title = updatedProduct.title;
  product.description = updatedProduct.description;
  product.imageUrl = updatedProduct.imageUrl;
  product.unit = updatedProduct.unit;
  product.stock = updatedProduct.stock;
  product.pricePerUnit = updatedProduct.pricePerUnit;
  product.category = updatedProduct.category;
  fs.writeFileSync("./app/data/products.json",JSON.stringify(products),"utf8")
}

function deleteProduct(uuid){
  let products= getProducts();
  for (let item in products ){
      if (products[item].uuid==uuid){
          products.splice(item, 1);
          fs.writeFileSync("./app/data/products.json",JSON.stringify(products),"utf8",)
          return true;
      }
  }
  return false;
}

function findProducts(products,query){
  let result=products;
  if (query==null) return result;
  query=query.split("&");
  console.log("buscando: "+query);
  for (let element in query ){
      query[element]=query[element].split("=")
  }
  for (let element in query ){
      if (query[element][0]=="category")
          result = result.filter(product => product.category == query[element][1]);
      if (query[element][0]=="title")
          result = result.filter(product => product.title ==query[element][1]);
  }
  return result
}

exports.getProducts = getProducts;
exports.getProductById = getProductById;
exports.createProduct = createProduct;
exports.updateProduct = updateProduct;
exports.deleteProduct = deleteProduct;
exports.findProducts = findProducts;