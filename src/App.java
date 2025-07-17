import java.util.Arrays;
import java.util.List;

import models.Cell;
import models.Maze;
import models.MazeSolver;
import models.MazeSolverRecursivo;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //runEjerciciosPD();
        runMaze();
        runEjercicio2_MazeRecursivo();

    }

    // private static void runEjerciciosPD() {
    //     EjerciciosPD ejerciciosPD = new EjerciciosPD();

    //     // Fibonacci Recursivo
    //     System.out.println("Fibonacci Recursivo:");
    //     long start = System.nanoTime();
    //     long resultado = ejerciciosPD.getFinobanci(50);
    //     long end = System.nanoTime();
    //     long duration = (end - start) / 1_000_000; // Convertimos a milisegundos
    //     System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " ms");

    //     // Fibonacci con Programación Dinámica
    //     System.out.println("Fibonacci con Programación Dinámica:");
    //     start = System.nanoTime();
    //     resultado = ejerciciosPD.getFinobanciPD(50);
    //     end = System.nanoTime();
    //     duration = (end - start);  // Convertimos a milisegundos
    //     System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " ms");
    //}

    private static void runMaze(){
        boolean[][] predefinedMaze = {
            { true, true, true ,true},
            { false, true, true, true},
            { true, true, false, false},
            { true, true, true, true}
        };

        // Clase MAZE con variable global predefinida
        Maze maze = new Maze(predefinedMaze);
        System.out.println("Laberinto cargado");
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);

        List<MazeSolver> solvers = Arrays.asList(
            new MazeSolverRecursivo()
        );
        MazeSolver solver = solvers.get(0);
        List<Cell> path;
        path = solver.getPath(maze.getGrid(), start, end);
        System.out.println(path);
    }
    
    private static void runEjercicio2_MazeRecursivo() {

        boolean[][] predefinedMaze = {
            { true, true, true ,true },
            { false, true, true, true },
            { true, true, false, false },
            { true, true, true, true }
        };

        Maze maze = new Maze(predefinedMaze);
        System.out.println("Ejercicio 2: Laberinto Recursivo");
        maze.printMaze();


        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);

        MazeSolver solver = new MazeSolverRecursivo();
        List<Cell> path = solver.getPath(maze.getGrid(), start, end);

        if (path.isEmpty()) {
            System.out.println(" No se encontró un camino.");
        } else {
            System.out.println(" Camino encontrado:");
            for (Cell cell : path) {
                System.out.println(cell);
            }
        }
    }
}