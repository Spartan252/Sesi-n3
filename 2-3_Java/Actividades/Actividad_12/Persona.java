package Actividades.Actividad_12;

public class Persona {

    private String nombre, apellidoPaterno, apellidoMaterno;
    private int edad;
    private String genero;

    public static final int ESTUDIANTE = 1;
    public static final int PROFESOR = 2;

    protected int tipo = 0;

    // Constructores____________________________________________________________
    public Persona() {
    }

    public Persona(String apellidoPaterno, String apellidoMaterno, String nombre, String genero, int edad) {
        setApellidoPaterno(apellidoPaterno);
        setApellidoMaterno(apellidoMaterno);
        setNombre(nombre);
        setGenero(genero);
        setEdad(edad);
    }

    // Setters______________________________________________________________
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Getters________________________________________________________________
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreCompleto() {
        return apellidoPaterno + " " + apellidoMaterno + " " + nombre;
    }

    public String getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    public int getTipo() {
        return tipo;
    }

    // Extras________________________________________________________________
    public boolean equals(Object o) {
        boolean retVal = false;
        if (o instanceof Persona) {
            Persona persona = (Persona) o;
            retVal = this.getNombreCompleto().equals(persona.getNombreCompleto());
        }
        return retVal;
    }

    public Persona clone(Persona persona) {
        return new Persona(persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getNombre(),
                persona.getGenero(), persona.getEdad());
    }

    public String toString() {
        return apellidoPaterno + ", " + apellidoMaterno + ", " + nombre + ",\n" + "genero: " + genero + ", " + "edad: "
                + edad + "\n";
    }
}