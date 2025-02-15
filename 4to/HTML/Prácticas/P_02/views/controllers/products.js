

class ProductException {
    constructor(errorMessage) {
        this.errorMessage = errorMessage;
    }
}


class Product {
    constructor(title, description, imageUrl, unit, stock, pricePerUnit, category) {
        this._uuid = generateUUID();
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.unit = unit;
        this.stock = stock;
        this.pricePerUnit = pricePerUnit;
        this.category = category;
    }

    //getters y setters
    get uuid() {
        return this._uuid;
    }
    
    
    get title() {
        return this._title;
    }

    set title(value) {
        if (typeof value !== 'string' || value.trim() === '') {
            throw new ProductException("Title must be a non-empty string.");
        }
        this._title = value;
    }

    get description() {
        return this._description;
    }

    set description(value) {
        if (typeof value !== 'string') {
            throw new ProductException("Description must be a string.");
        }
        this._description = value;
    }

    get imageUrl() {
        return this._imageUrl;
    }

    set imageUrl(value) {
        if (typeof value !== 'string') {
            throw new ProductException("ImageUrl must be a string.");
        }
        this._imageUrl = value;
    }

    get unit() {
        return this._unit;
    }

    set unit(value) {
        if (typeof value !== 'string' || value.trim() === '') {
            throw new ProductException("Unit must be a non-empty string.");
        }
        this._unit = value;
    }

    get stock() {
        return this._stock;
    }

    set stock(value) {
        if (typeof value !== 'number' || value < 0) {
            throw new ProductException("Stock must be a non-negative number.");
        }
        this._stock = value;
    }

    get pricePerUnit() {
        return this._pricePerUnit;
    }

    set pricePerUnit(value) {
        if (typeof value !== 'number' || value < 0) {
            throw new ProductException("PricePerUnit must be a non-negative number.");
        }
        this._pricePerUnit = value;
    }

    get category() {
        return this._category;
    }

    set category(value) {
        if (typeof value !== 'string' || value.trim() === '') {
            throw new ProductException("Category must be a non-empty string.");
        }
        this._category = value;
    }
    

    
    static createFromJson(jsonValue) {
        const parsedJson = JSON.parse(jsonValue);
        return new Product(
            parsedJson.title,
            parsedJson.description,
            parsedJson.imageUrl,
            parsedJson.unit,
            parsedJson.stock,
            parsedJson.pricePerUnit,
            parsedJson.category
        );
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

    static cleanObject(obj) {
        return {
            title: obj.title,
            description: obj.description,
            imageUrl: obj.imageUrl,
            unit: obj.unit,
            stock: obj.stock,
            pricePerUnit: obj.pricePerUnit,
            category: obj.category
        };
    }

}
