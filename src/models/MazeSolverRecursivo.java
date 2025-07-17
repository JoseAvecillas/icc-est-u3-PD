package models;

import java.util.*;

public class MazeSolverRecursivo implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        if (grid == null || grid.length == 0) {
            return new ArrayList<>();
        }

        List<Cell> path = new ArrayList<>();
        if (findPath(grid, start, end, path)) {
            Collections.reverse(path); // Para que el camino esté desde el inicio hasta el final
            return path;
        }

        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path) {
        // valido si la celda inicio su fila está dentro de mi grid, luego si la columna está dentro de mi grid 
        // y valido si la celda es transitable
        int row = start.row;
        int col = start.col;

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]) {
            return false;
        }

        // marcar como visitada para evitar ciclos
        grid[row][col] = false;

        // validar si es el final
        if (row == end.row && col == end.col) {
            path.add(start);
            return true;
        }

        // intentar moverme en las direcciones válidas
        if (findPath(grid, new Cell(row + 1, col), end, path)) {
            path.add(start);
            return true;
        }
        if (findPath(grid, new Cell(row, col + 1), end, path)) {
            path.add(start);
            return true;
        }
        if (findPath(grid, new Cell(row - 1, col), end, path)) {
            path.add(start);
            return true;
        }
        if (findPath(grid, new Cell(row, col - 1), end, path)) {
            path.add(start);
            return true;
        }

        return false;
    }
}