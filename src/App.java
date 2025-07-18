import java.util.HashSet;
import java.util.List;
import java.util.Set;

// ===== Modelos =====
import models.Cell;
import models.Maze;
import models.MazeResult;
import models.MazeSolver;
import models.MazeSolverRecursivo;
import models.MazeSolverRecursivoCompletoBT;
// import models.EjerciciosPD;   // ← descomenta si activas la parte de PD

public class App {

    // ─────────────────────────  MAIN  ─────────────────────────
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Parte 1: Laberinto con solver básico “exprés”
        runMaze();

        // Parte 2: Recursivo simple
        System.out.println("\n=== Parte 2: Método Recursivo Básico ===");
        MazeSolver solver1 = new MazeSolverRecursivo();
        runMazeSolver("Recursivo Básico", solver1);

        // Parte 3: Recursivo completo con backtracking
        System.out.println("\n=== Parte 3: Método Recursivo con Backtracking ===");
        MazeSolver solver2 = new MazeSolverRecursivoCompletoBT();
        runMazeSolverConVisitas("Recursivo Completo BT", solver2);

        // Parte 4: Ejercicios de Programación Dinámica  (mantener comentado si no lo usas)
        /*
        runEjerciciosPD();
        */
    }

    // ─────────────────────────  MAZE PREDEFINIDO  ─────────────────────────
    private static final boolean[][] predefinedMaze = {
        { true,  true,  true,  true },
        { false, true,  false,  true },
        { true,  true,  false, false },
        { true,  true,  true,  true }
    };
    private static final Cell start = new Cell(0, 0);
    private static final Cell end   = new Cell(3, 3);

    // ─────────────────────────  PARTE 1  ─────────────────────────
    private static void runMaze() {
        Maze maze = new Maze(predefinedMaze);
        System.out.println("Laberinto cargado");
        maze.printMaze();

        // Usamos cualquier solver (basta el recursivo básico para mostrar algo rápido)
        MazeSolver solver = new MazeSolverRecursivo();
        MazeResult result = solver.getPath(maze.getGrid(), start, end);

        System.out.println("Camino (solo impresión básica):");
        System.out.println(result.getPath());
    }

    // ─────────────────────────  PARTE 2  ─────────────────────────
    private static void runMazeSolver(String label, MazeSolver solver) {
        Maze maze = new Maze(predefinedMaze);
        MazeResult result = solver.getPath(maze.getGrid(), start, end);
        List<Cell> path = result.getPath();

        System.out.println(">> " + label);
        if (path.isEmpty()) {
            System.out.println("No se encontró un camino.");
        } else {
            System.out.println("Camino encontrado: " + path);
        }
    }

    // ─────────────────────────  PARTE 3  ─────────────────────────
    private static void runMazeSolverConVisitas(String label, MazeSolver solver) {
        Maze maze = new Maze(predefinedMaze);
        MazeResult result = solver.getPath(maze.getGrid(), start, end);
        List<Cell> path       = result.getPath();
        Set<Cell>  visitadas  = result.getVisitadas();

        System.out.println(">> " + label);
        if (path.isEmpty()) {
            System.out.println("No se encontró un camino.");
            return;
        }

        // Mostrar laberinto con celdas visitadas
        System.out.println("Celdas visitadas:");
        printMazeWithSymbols(predefinedMaze, visitadas);

        // Mostrar laberinto con camino final
        System.out.println("\nCamino recorrido:");
        printMazeWithSymbols(predefinedMaze, new HashSet<>(path));
    }

    // ________________________ Auxiliar ________________________
    private static void printMazeWithSymbols(boolean[][] grid, Set<Cell> marcadas) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Cell current = new Cell(i, j);
                if (!grid[i][j]) {
                    System.out.print("- ");
                } else if (marcadas.contains(current)) {
                    System.out.print("> ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    // ─────────────────────────  PRIMERA RESOLUCION PD ─────────────────────────
    /*
    private static void runEjerciciosPD() {
        EjerciciosPD ejerciciosPD = new EjerciciosPD();

        System.out.println("\n=== Fibonacci Recursivo ===");
        long startTime = System.nanoTime();
        long resultado = ejerciciosPD.getFinobanci(30);
        long endTime   = System.nanoTime();
        System.out.println("Resultado = " + resultado +
                           " en " + ((endTime - startTime) / 1_000_000) + " ms");

        System.out.println("\n=== Fibonacci con Programación Dinámica ===");
        startTime = System.nanoTime();
        resultado = ejerciciosPD.getFinobanciPD(30);
        endTime   = System.nanoTime();
        System.out.println("Resultado = " + resultado +
                           " en " + ((endTime - startTime) / 1_000_000) + " ms");
    }
    */
}