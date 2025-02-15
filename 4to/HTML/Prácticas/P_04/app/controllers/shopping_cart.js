

class ShoppingCartException {
    constructor(errorMessage) {
        this.errorMessage = errorMessage;
    }
}

class ProductProxy{
    constructor(productUuid,cantidad){
        this.productUuid = productUuid;
        this.cantidad = cantidad;
    }

    get productUuid(){
        return this.productUuid;
    }
    get cantidad(){
        return this._cantidad;
    }
    set productUuid(valueEnter){
        if (valueEnter !== undefined && valueEnter !== ''){
            this.productUuid = valueEnter;
        }
    }
    set cantidad(valueEnterC) {
        if (valueEnterC !== undefined && !isNaN(valueEnterC)) {
            this._cantidad = valueEnterC;
        }
    }
}

class ShoppingCart {
    constructor() {
        this.products = getProducts();
        this.proxi = [];
    }

    get products(){
        return this._products;
    }

    set products(value){
        this._products = [];
        if (typeof value=='string'){
            value = JSON.parse(value);
            this._products.push(Product.createFromObject(value));
        }
        if(Array.isArray(value)){
            for(let con in value){
                this._products.push(Product.createFromObject(value[con]));
            }
        }
        else{
            this._products.push(Product.createFromObject(value));
        }
    }

    addItem(productUuid, amount){
        var busqueda =
            this.proxi.findIndex(proxi=>
            proxi.prod_UUID === productUuid
        );
        if(amount < 0){
            throw new ShoppingCartException("La cantidad es negativa");
        }
        else if(busqueda !== -1){
            updateProduct(productUuid,amount);
        }
        else{
            this.proxi.push(new ProductProxy(productUuid,amount));
        }
    }

    updateItem(productUuid, newAmount){
        if(newAmount < 0){
            throw new ShoppingCartException("No ingresar cantidades negativas")
        }

        for(let temp of this.proxi){
            if(temp.prod_UUID === productUuid && newAmount === 0)
            {
                this.removeItem(productUuid);
            }
            else if(temp.prod_UUID === productUuid)
            {
                temp.cantidad = newAmount;
                break;
            }
        }
    }

    removeItem(productUuid){
        var busqueda =
            this.proxi.findIndex(proxi=>
            proxi.prod_UUID === productUuid
        );
        if(busqueda != -1){
            this.proxi.splice(busqueda,1);
            console.log("Eliminado")
        }
        else{
            throw new ShoppingCartException("No modificar los proxis");
        }
    }

    calculateTotal(){
        var totalProductos = 0;
        for (let cop in this.proxi){
            totalProductos += getProductById(this.proxi[cop].prod_UUID)._pricePerUnit * this.proxi[cop].cantidad;
        }
        return totalProductos;
    }
}

module.exports = ShoppingCart;