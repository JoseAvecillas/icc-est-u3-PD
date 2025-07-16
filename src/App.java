public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        runEjerciciosPD();

    }

    private static void runEjerciciosPD() {
        EjerciciosPD ejerciciosPD = new EjerciciosPD();

        // Fibonacci Recursivo
        System.out.println("Fibonacci Recursivo:");
        long start = System.nanoTime();
        long resultado = ejerciciosPD.getFinobanci(50);
        long end = System.nanoTime();
        long duration = (end - start) / 1_000_000; // Convertimos a milisegundos
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " ms");

        // Fibonacci con Programación Dinámica
        System.out.println("Fibonacci con Programación Dinámica:");
        start = System.nanoTime();
        resultado = ejerciciosPD.getFinobanciPD(50);
        end = System.nanoTime();
        duration = (end - start);  // Convertimos a milisegundos
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " ms");
    }
}