package Actividades.Actividad_12;

public class Profesor extends Persona {
    public static final int Especialidad = 0;
    public static final int Maestria = 1;
    public static final int Doctorado = 2;

    public static final int ISC = 0;
    public static final int ICSD = 1;
    public static final int ICY = 2;

    private int gradoAcademico;
    public int departamentoAdscrito;
    public int jornadaLaboral;
    public String gradoAcademicotxt;
    public String departamentoAdscritotxt;

    // Constructores____________________________________________________________
    public Profesor() {
        tipo = Persona.PROFESOR;
    }

    public Profesor(String apellidoPaterno, String apellidoMaterno, String nombre, String genero, int edad,
            int gradoAcademico, int departamentoAdscrito, int jornadaLaboral) {
        super(apellidoPaterno, apellidoMaterno, nombre, genero, edad);
        setgradoAcademico(gradoAcademico);
        setdepartamentoAdscrito(departamentoAdscrito);
        setjornadaLaboral(jornadaLaboral);
        tipo = Persona.PROFESOR;
    }

    // Setters______________________________________________________________
    public void setgradoAcademico(int gradoAcademico) {
        if (gradoAcademico >= Especialidad && gradoAcademico <= Doctorado) {
            this.gradoAcademico = gradoAcademico;
            if (gradoAcademico == 0)
                gradoAcademicotxt = "Especialidad";
            else if (gradoAcademico == 1)
                gradoAcademicotxt = "Maestria";
            else
                gradoAcademicotxt = "Doctorado";
        }
    }

    public void setdepartamentoAdscrito(int departamentoAdscrito) {
        if (departamentoAdscrito >= ISC && departamentoAdscrito <= ICY) {
            this.departamentoAdscrito = departamentoAdscrito;
            if (departamentoAdscrito == 0)
                departamentoAdscritotxt = "ISC";
            else if (departamentoAdscrito == 1)
                departamentoAdscritotxt = "ICSD";
            else
                departamentoAdscritotxt = "ICY";
        }
    }

    public void setjornadaLaboral(int jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }

    // Getters________________________________________________________________
    public int getGradoAcademico() {
        return gradoAcademico;
    }

    public int getDepartamentoAdscrito() {
        return departamentoAdscrito;
    }

    public int getJornadaLaboral() {
        return jornadaLaboral;
    }

    // Extras________________________________________________________________
    public Estudiante clone(Profesor pr) {
        return new Estudiante(pr.getApellidoPaterno(), pr.getApellidoPaterno(),
                pr.getNombre(), pr.getGenero(), pr.getEdad(), pr.getGradoAcademico(), pr.getDepartamentoAdscrito(),
                pr.getJornadaLaboral());
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "Grado Academico: " + gradoAcademicotxt + "\nDepartamento Adscrito: "
                + departamentoAdscritotxt + ", " + "Jornada Laboral: " + jornadaLaboral + "\n";
    }
}
