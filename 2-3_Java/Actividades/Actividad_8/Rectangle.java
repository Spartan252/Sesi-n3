package Actividades.Actividad_8;

public class Rectangle {
    private double base; // Atributos o variables de clase
    private double height;

    // Constructores
    public Rectangle() {
        base = 1.0;
        height = 1.0;
    }

    public Rectangle(double side) {
        setBase(side);
        setHeight(side);
    }

    public Rectangle(double base, double height) {
        setBase(base);
        setHeight(height);
    }

    // Setters
    public void setBase(double base) {
        if (base >= 1 && base < 100)
            this.base = base;
    }

    public void setHeight(double h) {
        if (h >= 1 && h < 100)
            height = h;
    }

    // Getters
    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public double getPerimeter() {
        return 2 * base + 2 * height;
    }

    public double getArea() {
        return base * height;
    }

    public Rectangle clone() {
        return new Rectangle(base, height); // Retorna una nueva instancia (objeto)
                                            // con los mismos valores de la base y altura
    }

    /*
     * public boolean equals(Rectangle rec) {
     * boolean retVal = rec.getBase() == base && rec.getHeight() == height;
     * return retVal;
     * }
     */

    public boolean equals(Object o) {
        boolean retVal = false;
        if (o instanceof Rectangle) {
            Rectangle rec = (Rectangle) o;
            retVal = rec.getBase() == base && rec.getHeight() == height;
        }

        return retVal;
    }

    public String toString() {
        return "{\"base\":" + base + ",\"height\":" + height + "}";
        // return "La base es "+base+" y la altura es "+height;
    }

    // Destructor
    protected void finalize() {
        System.out.println("Se destruye " + this);
    }

}