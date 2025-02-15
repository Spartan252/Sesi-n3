package Actividades.Actividad_12;

public class Estudiante extends Persona {
    public static final int ISC = 0;
    public static final int ICSD = 1;
    public static final int ICY = 2;

    private int planDeEstudios;
    public int creditosCursados;
    public int semestresCursados;
    public String planDeEstudiostxt;

    // Constructores____________________________________________________________
    public Estudiante() {
        tipo = Persona.ESTUDIANTE;
    }

    public Estudiante(String apellidoPaterno, String apellidoMaterno, String nombre, String genero, int edad,
            int planDeEstudios, int creditosCursados, int semestresCursados) {
        super(apellidoPaterno, apellidoMaterno, nombre, genero, edad);
        setPlanDeEstudios(planDeEstudios);
        setcreditosCursados(creditosCursados);
        setsemestresCursados(semestresCursados);
        tipo = Persona.ESTUDIANTE;
    }

    // Setters______________________________________________________________
    public void setPlanDeEstudios(int planDeEstudios) {
        if (planDeEstudios >= ISC && planDeEstudios <= ICY) {
            this.planDeEstudios = planDeEstudios;
            if (planDeEstudios == 0)
                planDeEstudiostxt = "ISC";
            else if (planDeEstudios == 1)
                planDeEstudiostxt = "ICSD";
            else
                planDeEstudiostxt = "ICY";
        }
    }

    public void setcreditosCursados(int creditosCursados) {
        this.creditosCursados = creditosCursados;
    }

    public void setsemestresCursados(int semestresCursados) {
        this.semestresCursados = semestresCursados;
    }

    // Getters________________________________________________________________
    public int getPlanDeEstudios() {
        return planDeEstudios;
    }

    public int getCreditosCursados() {
        return creditosCursados;
    }

    public int getSemestresCursados() {
        return semestresCursados;
    }

    // Extras________________________________________________________________
    public Estudiante clone(Estudiante e) {
        return new Estudiante(e.getApellidoPaterno(), e.getApellidoPaterno(),
                e.getNombre(), e.getGenero(), e.getEdad(), e.getPlanDeEstudios(), e.getCreditosCursados(),
                e.getSemestresCursados());
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "planDeEstudios: " + planDeEstudiostxt + "\nCreditos Cursados: "
                + creditosCursados + ", " + "Semestres Cursados: " + semestresCursados + "\n";
    }
}
