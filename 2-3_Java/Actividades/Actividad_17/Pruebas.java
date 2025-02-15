
public abstract class Pruebas implements HelloWorld {
    public static void main(String[] args) {

        // Clases Anónimas

        //Estudiante
        Person estudiante = new Person() {
            @Override
            public void work() {
                System.out.println("El estudiante está en clase");
            }
        };

        // Profesor
        Person profesor = new Person() {
            @Override
            public void work() {
                System.out.println("El profesor está impartiendo cátedra");
            }
        };

        //Español
        HelloWorld español = new HelloWorld() {
            @Override
            public void greet() {
                System.out.println("¡Hola!");
            }

            @Override
            public void greetSomeone(String someone) {
                System.out.println("¡Hola, " + someone + "!");
            }
        };


        //Inglés
        HelloWorld inglés = new HelloWorld() {
            @Override
            public void greet() {
                System.out.println("Hello!");
            }

            @Override
            public void greetSomeone(String someone) {
                System.out.println("Hello, " + someone + "!");
            }
        };

        //Francés
        HelloWorld francés = new HelloWorld() {
            @Override
            public void greet() {
                System.out.println("Bonjour !");
            }

            @Override
            public void greetSomeone(String someone) {
                System.out.println("Bonjour, " + someone + " !");
            }
        };

        // Pruebas

        //Español
        español.greet();
        español.greetSomeone("Juan");

        System.out.println();

        //Inglés
        inglés.greet();
        inglés.greetSomeone("Jhon");

        System.out.println();

        //Francés
        francés.greet();
        francés.greetSomeone("Jean");

        System.out.println();

        //Person
        estudiante.work();
        profesor.work();
    }
}
