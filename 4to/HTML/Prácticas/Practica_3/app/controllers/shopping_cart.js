class ShoppingCart
{
    //Crearemos los 2 arreglos de proxies y productos donde estaran las copias.
    constructor()
    {
        this.products = getProducts();
        this.proxi = [];
    }


    get products(){
        return this._products;
    }
    set products(value)
    {
        this._products = [];
        if (typeof value=='string')
        {
            value = JSON.parse(value);
            this._products.push(Product.createFromObject(value));
        }
        if(Array.isArray(value))
        {
            for(let con in value)
            {
                this._products.push(Product.createFromObject(value[con]));
            }
        }
        else
        {
            this._products.push(Product.createFromObject(value));
        }
    }

    // Funciones de CRUD


    addItem(productUuid, amount)
    {

        var busqueda =
            this.proxi.findIndex(proxi=>
            proxi.prod_UUID === productUuid
        );
        if(amount < 0)
        {
            throw new ShoppingCartException("La cantidad es negativa");
        }
        else if(busqueda !== -1)
        {

            updateProduct(productUuid,amount);
        }
        else
        {
            this.proxi.push(new ProductProxy(productUuid,amount));
        }


    }

    // Odio esta madre
    updateItem(productUuid, newAmount)
    {

        if(newAmount < 0)
        {
            throw new ShoppingCartException("No se pueden ingresar cantidades negativas")
        }

        for(let temp of this.proxi)
        {
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



    removeItem(productUuid)
    {
        var busqueda =
            this.proxi.findIndex(proxi=>
            proxi.prod_UUID === productUuid
        );
        if(busqueda != -1)
        {

            this.proxi.splice(busqueda,1);
            console.log("Eliminado")
        }
        else
        {
            throw new ShoppingCartException("No se pueden modificar los proxis");
        }


    }

    calculateTotal()
    {
        var totalProductos = 0;

        for (let cop in this.proxi)
        {
            totalProductos += getProductByUUID(this.proxi[cop].prod_UUID)._pricePerUnit * this.proxi[cop].cantidad;
        }
        return totalProductos;
    }


}

class ProductProxy
{
    constructor(prod_UUID,cantidad)
    {
        this.prod_UUID = prod_UUID;
        this.cantidad = cantidad;
    }
    //Getters y setters
    get prod_UUID()
    {
        return this._prod_UUID;
    }
    get cantidad() {
        return this._cantidad;
    }
    set prod_UUID(valueEnter)
    {
        if (valueEnter !== undefined && valueEnter !== '')
        {
            this._prod_UUID = valueEnter;
        }
    }

    set cantidad(valueEnterC) {
        if (valueEnterC !== undefined && !isNaN(valueEnterC)) {
            this._cantidad = valueEnterC;
        }
    }
}

class ShoppingCartException
{
    constructor(errorMessage)
    {
        this.errorMessage = errorMessage;
    }
}

module.exports = ShoppingCart;