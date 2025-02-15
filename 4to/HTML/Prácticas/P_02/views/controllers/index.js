

// 1. Lista vacia
console.log("Arreglo de productos vacío:");
console.table(getProducts());

// 1. Lista elementos
console.log("Agregando productos al arreglo:");
let product1 = new Product("SantiagoElíJiménezAuilar745267_1", "Descripción1", "url1", "pieza", 10, 52, "Categoría1");
let product2 = new Product("SantiagoElíJiménezAuilar745267_2", "Descripción2", "url2", "pieza", 20, 81, "Categoría2");
let product3 = new Product("SantiagoElíJiménezAuilar745267_3", "Descripción3", "url3", "pieza", 15, 12, "Categoría1");
let product4 = new Product("SantiagoElíJiménezAuilar745267_4", "Descripción4", "url4", "pieza", 30, 73, "Categoría4");

createProduct(product1);
createProduct(product2);
createProduct(product3);
createProduct(product4);

console.log("Arreglo de productos:");
console.table(getProducts());

// 3. Actualizar nombres 2 productos
console.log("Actualizando nombres de productos:");
product2.title = "SantiagoElíJiménezAuilar745267_5";
product3.title = "SantiagoElíJiménezAuilar745267_6";
updateProduct(product2.title, product2);
updateProduct(product3.title, product3);

console.log("Arreglo de productos actualizados:");
console.table(getProducts());

// 4. Eliminar producto
console.log("Eliminando producto:");
deleteProduct(product4.title);

console.log("Arreglo de productos después de eliminar:");
console.table(getProducts());

// 5. Excepciones
try {
    console.log("Producto con título vacío");
    const invalidProduct = new Product("", "Descripción inválida", "url", "pieza", 10, 5.0, "Categoría");
} catch (error) {
    console.error("Excepción atrapada:", error.errorMessage);
}

// 6. Carrito de compras
console.log("Agregando elementos carrito de compras:");
const cart = new ShoppingCart();
cart.addItem(product1.uuid, 2);
cart.addItem(product2.uuid, 1);
cart.addItem(product3.uuid, 3);

console.log("Carrito de compras:");
console.table(cart.productProxies);

// 7. Actualización de producto en carrito
console.log("Actualizando un producto en carrito:");
cart.updateItem(product1.uuid, 5);
console.log("Carrito de compras actualizado:");
console.table(cart.productProxies);

// 8. Elimina un producto del carrito
console.log("Eliminando un producto del carrito:");
cart.removeItem(product2.uuid);
console.log("Carrito de compras después de eliminar:");
console.table(cart.productProxies);

// 9. Verifica el total en el carrito de compras
console.log("Total del carrito de compras:", cart.calculateTotal());
