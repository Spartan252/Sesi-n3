// home.js

// Función para cargar los productos
async function loadProducts(page = 1) {
    try {
        const response = await fetch(`/products?page=${page}`);
        const products = await response.json();

        // Limpiar el contenedor de productos
        const productContainer = document.getElementById('product-container');
        productContainer.innerHTML = '';
    
        // Iterar sobre los productos y crear los elementos HTML
        products.forEach(product => {
            const productElement = createProductElement(product);
            productContainer.appendChild(productElement);
        });
    
        // Actualizar la paginación
        updatePagination(page, products.length);
    } 
    catch (error) {
        console.error('Error al cargar los productos:', error);
    }
}
    
    // Función para crear un elemento de producto
function createProductElement(product) {
    const productElement = document.createElement('div');
    productElement.classList.add('col');
    
    // Aquí se crea la estructura HTML del elemento de producto
    // utilizando los datos del producto recibido
    
    // Agregar evento al botón "Añadir a carrito"
    const addToCartButton = productElement.querySelector('.add-to-cart');
    addToCartButton.addEventListener('click', () => addToCart(product.uuid, 1));
    
    return productElement;
}
    
    // Función para actualizar la paginación
function updatePagination(currentPage, totalProducts) {
    const paginationContainer = document.getElementById('pagination');
    paginationContainer.innerHTML = '';
    
    // Aquí se crea la estructura HTML de la paginación
    // utilizando el número de página actual y el total de productos
}
    
// Cargar los productos en la página de inicio
loadProducts();