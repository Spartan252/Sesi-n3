package Actividades.Actividad_21;

public class GDrawer<Type> {
    private Type ObjectInside = null;

    public void put(Type o) {
        if (this.ObjectInside == null)
            this.ObjectInside = o;
    }
    
    public Type peek() {
        return this.ObjectInside;
    }

    public Type remove() {
        Type tmp = this.ObjectInside;
        this.ObjectInside = null;
        return tmp;
    }

    public String toString() {
        if (this.ObjectInside == null)
            return "Cajón vacio";
        else
            return "Cajón: [" + ObjectInside + "]";
    }
    
}
