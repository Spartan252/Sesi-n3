const {generateUUID} = require("./utils");

class ProductException {
    constructor(errorMessage) {
        this.errorMessage = errorMessage;
    }
}


class Product {
    constructor( _Object,title,description,imageURL,unit,stock,pricePerUnit,category){
        this._uuid = _Object._uuid || generateUUID();
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
        this.unit = unit;
        this.stock = stock;
        this.pricePerUnit = pricePerUnit;
        this.category = category;
    }

    //getters y setters
    set uuid(value){
        throw new ProductException("La uuid se genera automáticamente");
    }

    get uuid(){
        return this._uuid;
    }

    set title(title){
        if (typeof title !== 'string' || title === ""){
            throw new ProductException("No puedes ingresar elementos vacios");
        }
        this._title = title;
    }
    
    get title(){
        return this._title;
    }

    set description(description){
        if (typeof description !== 'string' || description === "") {
            throw new ProductException("No puedes ingresar elementos vacios");
        }
        this._description = description;
    }

    get description(){
        return this._description;
    }

    set imageURL(imageURL){
        if (typeof imageURL !== 'string' || imageURL === "") {
            throw new ProductException("No puedes ingresar elementos vacios");
        }
        this._imageURL = imageURL;
    }

    get imageURL(){
        return this._imageURL;
    }

    set unit(unit){
        if (typeof unit !== 'string' || unit === "") {
            throw new ProductException("No puedes ingresar elementos vacios");
        }
        this._unit = unit;
    }

    get unit(){
        return this._unit;
    }

    set stock(stock){
        if (stock < 0 || typeof  stock === 'string') {
            throw new ProductException("Ingrese una cantidad positiva");
        }
        this._stock = stock;
    }

    get stock(){
        return this._stock;
    }

    set pricePerUnit(pricePerUnit){
        if (pricePerUnit < 0 || typeof pricePerUnit === 'string') {
            throw new ProductException("Ingrese una cantidad positiva");
        }
        this._pricePerUnit = pricePerUnit;
    }

    get pricePerUnit(){
        return this._pricePerUnit;
    }
    
    set category(category){
        if (typeof category !== 'string' || category === "") {
            throw new ProductException("No puedes ingresar elementos vacios");
        }
        this._category = category;
    }

    get category(){
        return this._category;
    }
    

    static createFromJson(jsonValue){
        var Object = JSON.parse(jsonValue);
        return Product.createFromObject(Object);
    }


    static createFromObject(obj) {
        return new Product(
            obj.title,
            obj.description,
            obj.imageUrl,
            obj.unit,
            obj.stock,
            obj.pricePerUnit,
            obj.category
        );
    }
    static createFromObject(obj)
    {
        const objte = obj;
        return new Product
        (
            obj,
            objte._title,
            objte._description,
            objte._imageURL,
            objte._unit,
            objte._stock,
            objte._pricePerUnit,
            objte._category
        );
    }

    static cleanObject(obj){
        var exampleObject = ['title', 'description', 'imageURL', 'unit', 'stock', 'pricePerUnit', 'category'];
        for(let newObj in obj){
            if(exampleObject.indexOf(newObj) === -1){
                delete obj[newObj];
                console.log("\nSe han eleminiado propiedades\n")
            }
        }
        return obj;
    }
}

module.exports = Product;