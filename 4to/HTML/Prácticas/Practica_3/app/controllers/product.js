const {generateUUID} = require("./utils");

class ProductException
{
    constructor(errorMessage)
    {
        this.errorMessage = errorMessage;
    }
}

class Product
{
    //Constructor
    constructor( _Object,title,description,imageURL,unit,stock,pricePerUnit,category)
    {

        this._uuid = _Object._uuid || generateUUID();
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
        this.unit = unit;
        this.stock = stock;
        this.pricePerUnit = pricePerUnit;
        this.category = category;
    }

    // Setters y getters


    set uuid(value)
    {
        throw new ProductException("Product uuids are auto-generated");
    }

    set title(title)
    {
        if (typeof title !== 'string' || title === "")
        {
            throw new ProductException("No puedes ingresar elementos vacios 1");
        }
        this._title = title;
    }

    set description(description)
    {
        if (typeof description !== 'string' || description === "") {
            throw new ProductException("No puedes ingresar elementos vacios 2");
        }
        this._description = description;
    }

    set imageURL(imageURL)
    {
        if (typeof imageURL !== 'string' || imageURL === "") {
            throw new ProductException("No puedes ingresar elementos vacios 3");
        }
        this._imageURL = imageURL;
    }


    set unit(unit)
    {
        if (typeof unit !== 'string' || unit === "") {
            throw new ProductException("No puedes ingresar elementos vacios 4");
        }
        this._unit = unit;
    }

    set stock(stock)
    {
        if (stock < 0 || typeof  stock === 'string') {
            throw new ProductException("Ingrese una cantidad positiva 1");
        }
        this._stock = stock;
    }

    set pricePerUnit(pricePerUnit)
    {
        if (pricePerUnit < 0 || typeof pricePerUnit === 'string') {
            throw new ProductException("Ingrese una cantidad positiva 2");
        }
        this._pricePerUnit = pricePerUnit;
    }

    set category(category)
    {
        if (typeof category !== 'string' || category === "") {
            throw new ProductException("No puedes ingresar elementos vacios 5");
        }
        this._category = category;
    }

    get uuid()
    {
        return this._uuid;
    }

    get title(){
        return this._title;
    }

    get description(){
        return this._description;
    }
    get imageURL(){
        return this._imageURL;
    }
    get unit(){
        return this._unit;
    }
    get stock(){
        return this._stock;
    }
    get pricePerUnit(){
        return this._pricePerUnit;
    }
    get category(){
        return this._category;
    }


    static createFromJson(jsonValue)
    {
        var Object = JSON.parse(jsonValue);
        return Product.createFromObject(Object);
    }



    static cleanObject(ObjectEnter)
    {
        var exampleObject = ['title', 'description', 'imageURL', 'unit', 'stock', 'pricePerUnit', 'category'];

        for(let newObj in ObjectEnter)
        {
            if(exampleObject.indexOf(newObj) === -1)
            {
                delete ObjectEnter[newObj];
                console.log("\n  Se han eleminiado propiedades \n")
            }
        }

        return ObjectEnter;
    }

    // Odio javascript


    static createFromObject(_Object)
    {
        const tempObjecto_to_Product = _Object;
        return new Product
        (
            _Object,
            tempObjecto_to_Product._title,
            tempObjecto_to_Product._description,
            tempObjecto_to_Product._imageURL,
            tempObjecto_to_Product._unit,
            tempObjecto_to_Product._stock,
            tempObjecto_to_Product._pricePerUnit,
            tempObjecto_to_Product._category
        );
    }


}

module.exports = Product;

