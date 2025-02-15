

class ShoppingCartException {
    constructor(errorMessage) {
        this.errorMessage = errorMessage;
    }
}

class ProductProxy {
    constructor(productUuid, amount) {
        this.productUuid = productUuid;
        this.amount = amount;
    }
}

class ShoppingCart {
    constructor() {
        this.productProxies = [];
        this.products = [];
    }

    addItem(productUuid, amount) {
        const existingProduct = this.productProxies.find(proxy => proxy.productUuid === productUuid);

        if (existingProduct) {
            existingProduct.amount += amount;
        } else {
            this.productProxies.push(new ProductProxy(productUuid, amount));
        }
    }

    updateItem(productUuid, newAmount) {
        const proxyToUpdate = this.productProxies.find(proxy => proxy.productUuid === productUuid);
    
        if (!proxyToUpdate) {
            throw new ShoppingCartException(`Product with UUID ${productUuid} not found in the cart.`);
        }

        proxyToUpdate.amount = newAmount;
    
        if (newAmount === 0) {
            this.removeItem(productUuid);
        }
    }

    removeItem(productUuid) {
        this.productProxies = this.productProxies.filter(proxy => proxy.productUuid !== productUuid);
    }

    calculateTotal() {
        let total = 0;

        for (const proxy of this.productProxies) {
            const product = this.products.find(prod => prod.uuid === proxy.productUuid);
            if (!product) {
                throw new ShoppingCartException(`Product with UUID ${proxy.productUuid} not found.`);
            }
            total += product.pricePerUnit * proxy.amount;
        }
    
        return total;
    }
}