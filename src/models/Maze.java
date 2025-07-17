package models;

public class Maze {
    
    private boolean[][] predefinedMaze;
    private boolean[][] grid;

    public Maze(boolean[][] predefinedMaze) {
        this.predefinedMaze = predefinedMaze;
        this.grid = new boolean[predefinedMaze.length][predefinedMaze[0].length];
        for (int i = 0; i < predefinedMaze.length; i++) {
            System.arraycopy(predefinedMaze[i], 0, this.grid[i], 0, predefinedMaze[i].length);
        }
    }

    public void printMaze() {
        for (int i = 0; i < predefinedMaze.length; i++) {
            for (int j = 0; j < predefinedMaze[i].length; j++) {
                if (predefinedMaze[i][j]) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }

    public boolean[][] getGrid() {
        // Retorna la copia si quieres proteger el grid original, o retorna directamente:
        return grid;
    }
}