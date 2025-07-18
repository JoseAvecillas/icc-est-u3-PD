package models;

import java.util.*;

public class MazeSolverRecursivo implements MazeSolver {

    @Override
    public MazeResult  getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        Set<Cell> visitada = new HashSet<>();

        if (grid == null || grid.length == 0) {
            return new MazeResult(new ArrayList<>(), visitada);
        }

        if (findPath(grid, start, end, path, visitada)) {
            Collections.reverse(path); // Reversar para que vaya de start a end
            return new MazeResult(path, visitada);
        }

        return new MazeResult(new ArrayList<>(), visitada);
    }

    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path, Set<Cell> visitada) {
        int row = current.row;
        int col = current.col;

        // Verificar límites y si la celda es transitable
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]) {
            return false;
        }

        // Si ya fue visitada, no continuar
        if (visitada.contains(current)) {
            return false;
        }

        // Marcar como visitada
        visitada.add(current);

        // Verificar si es el final
        if (row == end.row && col == end.col) {
            path.add(current);
            return true;
        }

        // Moverse en las 4 direcciones
        if (findPath(grid, new Cell(row + 1, col), end, path, visitada) ||
            findPath(grid, new Cell(row, col + 1), end, path, visitada) ||
            findPath(grid, new Cell(row - 1, col), end, path, visitada) ||
            findPath(grid, new Cell(row, col - 1), end, path, visitada)) {
            path.add(current);
            return true;
        }

        return false;
    }
}