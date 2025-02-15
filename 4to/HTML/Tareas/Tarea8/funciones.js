// Función para mostrar todos los productos
function showProducts() {
    fetch('http://localhost:3000/products')
    .then(response => response.json())
    .then(products => {
        console.log("Productos disponibles:");
        products.forEach(product => {
            console.log(`Nombre: ${product.name} - SKU: ${product.sku} - Precio: $${product.price}`);
        });
    })
    .catch(error => console.error('Error al obtener los productos:', error));
}

// Función para agregar un producto
function addProduct(producto) {
    fetch('http://localhost:3000/products', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(producto),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Producto añadido correctamente:', data);
    })
    .catch(error => console.error('Error al agregar el producto:', error));
}

// Función para mostrar un producto por su nombre
function showProductByName(name) {
    fetch(`http://localhost:3000/products?name=${name}`)
    .then(response => response.json())
    .then(products => {
        if (products.length > 0) {
            const product = products[0];
            console.log(`Producto encontrado: Nombre: ${product.name} - Precio: $${product.price}`);
        } else {
            console.log(`No se encontró ningún producto con el nombre "${name}".`);
        }
    })
    .catch(error => console.error('Error al buscar el producto por nombre:', error));
}
v