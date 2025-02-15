package Actividades.Actividad_12;

public class Test_Personas {
    public static void main(String[] args) {

    // Persona(String apellidoPaterno, String apellidoMaterno, String nombre, String genero, int edad)
    // Estudiante(String apellidoPaterno, String apellidoMaterno, String nombre, String genero, int edad, int planDeEstudios, int creditosCursados, int semestresCursados)
    // Profesor(String apellidoPaterno, String apellidoMaterno, String nombre, String genero, int edad, int gradoAcademico, int departamentoAdscrito, int jornadaLaboral)

        Estudiante e1 = new Estudiante();

        e1.setApellidoPaterno("Santoro");
        e1.setApellidoMaterno("Ibarra");
        e1.setNombre("Carlo Alessandro");
        e1.setGenero("Masculino");
        e1.setEdad(18);
        e1.setPlanDeEstudios(Estudiante.ISC);

        System.out.println("e1:" + e1);

        Estudiante e2 = new Estudiante("De La Mora", "Wolburg", "Angel Gerardo", "Masculino", 23, Estudiante.ICSD, 23,
                1);

        System.out.println("e2:" + e2);

        Persona p3 = new Persona("Flores", "Reyes", "Regina", "Femenino", 21);
        Estudiante e3 = new Estudiante("Flores", "Reyes", "Regina", "Femenino", 21, Estudiante.ICSD, 45, 2);

        System.out.println("p3:" + p3);
        System.out.println("e3:" + e3);

        if (e3.equals(p3)) {
            System.out.println("e3 y p3 Si son iguales");
        }

        Estudiante e4 = new Estudiante("Flores", "Reyes", "Regina", "Femenino", 21, Estudiante.ICSD, 45, 2);
        if (e3.equals(e4)) {
            System.out.println("e3 y e4 Si son iguales");
        }
        //// mmmmmmmmmm

        Profesor pr1 = new Profesor("Martinez", "Perez", "Rodrigo", "Masculino", 45, Profesor.ICSD, 2, 8);

        System.out.println("pr1:" + pr1);

        Persona p4 = new Persona("Navarro", "Chavez", "Maria", "Femenino", 53);
        Profesor pr2 = new Profesor("Navarro", "Chavez", "Maria", "Femenino", 53, 1, 0, 6);

        System.out.println("p4:" + p4);
        System.out.println("pr2:" + pr2);

        if (pr2.equals(p4)) {
            System.out.println("pr2 y p4 Si son iguales\n");
        }

        Profesor pr3 = new Profesor("Torres", "Reyes", "Diego", "Masculino", 65, 2, 1, 7);
        System.out.println("pr3:" + pr3);

    }
}
