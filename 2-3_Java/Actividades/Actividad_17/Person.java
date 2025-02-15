

public abstract class Person {

    private int edad, sexo;
    public static final int MALE = 0, FEMALE = 1;

    public void work() {
        System.out.println("No está trabajando");
    }

    // Setters_______________________________________________
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    // Getters_______________________________________________
    public int getEdad() {
        return edad;
    }

    public void getSexo() {
        if (sexo == 0)
            System.out.println("Masculino");
        else if (sexo == 1)
            System.out.println("Masculino");
    }

}
