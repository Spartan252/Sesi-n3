// shopping_cart.js

// Función para agregar un producto al carrito
async function addToCart(productUuid, quantity) {
    try {
        // Hacer una petición al servidor para agregar el producto al carrito
        const response = await fetch('/shopping-cart', {
            method: 'POST',
            headers: {
            'Content-Type': 'application/json'
            },
            body: JSON.stringify({ productUuid, quantity })
        });
    
        if (response.ok) {
            // Actualizar el carrito en el sessionStorage
            updateCartInSessionStorage();
            // Mostrar una notificación o actualizar la interfaz de usuario
        } else {
            throw new Error('Error al agregar el producto al carrito');
        }
    }
    catch (error) {
        console.error('Error al agregar el producto al carrito:', error);
    }
}

  // Función para actualizar el carrito en el sessionStorage
async  function updateCartInSessionStorage() {
    // Hacer una petición al servidor para obtener el carrito actual
    const response = await fetch('/shopping-cart');
    const cart = await response.json();

    // Guardar el carrito en el sessionStorage
    sessionStorage.setItem('cart', JSON.stringify(cart));
}


// shopping_cart.js

// Función para cargar el carrito desde el sessionStorage
function loadCartFromSessionStorage() {
    const cartString = sessionStorage.getItem('cart');
    if (cartString) {
        const cart = JSON.parse(cartString);
      // Actualizar la interfaz de usuario con los productos del carrito
        updateCartUI(cart);
    }
}

  // Función para actualizar la interfaz de usuario del carrito
function updateCartUI(cart) {
    const cartContainer = document.getElementById('cart-container');
    cartContainer.innerHTML = '';

    cart.forEach(item => {
        const cartItem = createCartItemElement(item);
        cartContainer.appendChild(cartItem);
    });

    // Actualizar el total del carrito
    updateCartTotal(cart);
}

// Cargar el carrito desde el sessionStorage al inicio
loadCartFromSessionStorage();



// shopping_cart.js

// Función para actualizar la cantidad de un producto en el carrito
async function updateCartItem(productUuid, newQuantity) {
    try {
      // Hacer una petición al servidor para actualizar la cantidad del producto
        const response = await fetch(`/shopping-cart/${productUuid}`, {
            method: 'PUT',
            headers: {
            'Content-Type': 'application/json'
            },
            body: JSON.stringify({ quantity: newQuantity })
        });
    
        if (response.ok) {
            // Actualizar el carrito en el sessionStorage
            updateCartInSessionStorage();
            // Actualizar la interfaz de usuario del carrito
            updateCartUI(await response.json());
        } else {
            throw new Error('Error al actualizar la cantidad del producto');
        }
    } 
    catch (error) {
        console.error('Error al actualizar la cantidad del producto:', error);
    }
}


// shopping_cart.js

// Función para eliminar un producto del carrito
async function removeFromCart(productUuid) {
    try {
        // Hacer una petición al servidor para eliminar el producto del carrito
        const response = await fetch(`/shopping-cart/${productUuid}`, {
            method: 'DELETE'
        });
    
        if (response.ok) {
            // Actualizar el carrito en el sessionStorage
            updateCartInSessionStorage();
            // Actualizar la interfaz de usuario del carrito
            updateCartUI(await response.json());
        } else {
            throw new Error('Error al eliminar el producto del carrito');
        }
    }
    catch (error) {
        console.error('Error al eliminar el producto del carrito:', error);
    }
}


// admin_products.js

// Función para crear un nuevo producto
async function createProduct(productData) {
    try {
        const response = await fetch('/admin/products', {
            method: 'POST',
            headers: {
            'Content-Type': 'application/json',
            'x-auth': 'admin'
            },
            body: JSON.stringify(productData)
        });
    
        if (response.ok) {
            // Mostrar una notificación o actualizar la lista de productos
        } else {
            throw new Error('Error al crear el producto');
        }
    } 
    catch (error) {
        console.error('Error al crear el producto:', error);
    }
}

// Función para actualizar un producto
async function updateProduct(productUuid, updatedData) {
    try {
        const response = await fetch(`/admin/products/${productUuid}`, {
            method: 'PUT',
            headers: {
            'Content-Type': 'application/json',
            'x-auth': 'admin'
            },
            body: JSON.stringify(updatedData)
        });
    
        if (response.ok) {
            // Mostrar una notificación o actualizar la lista de productos
        } else {
            throw new Error('Error al actualizar el producto');
        }
    } 
    catch (error) {
        console.error('Error al actualizar el producto:', error);
    }
}

  // Función para eliminar un producto
async function deleteProduct(productUuid) {
    try {
        const response = await fetch(`/admin/products/${productUuid}`, {
            method: 'DELETE',
            headers: {
            'x-auth': 'admin'
            }
        });
    
        if (response.ok) {
            // Mostrar una notificación o actualizar la lista de productos
        } else {
            throw new Error('Error al eliminar el producto');
        }
    } 
    catch (error) {
        console.error('Error al eliminar el producto:', error);
    }
}