package models;

import java.util.*;
// ESTO ES EL DFS
// ESTO ES EL DFS 
// 
public class MazeSolverRecursivoCompletoBT implements MazeSolver {

    private List<Cell> path;
    private Set<Cell> visitada; 
    private boolean[][] grid;
    private Cell end;

    public MazeSolverRecursivoCompletoBT() {
        path = new ArrayList<>();
        visitada = new HashSet<>();
    }

    @Override
    public MazeResult getPath(boolean[][] grid, Cell start, Cell end) {
        path.clear();
        visitada.clear();
        this.grid = grid;
        this.end = end;

        if (grid == null || grid.length == 0) {
            return new MazeResult(new ArrayList<>(), visitada);
        }

        if (findPath(start)) {
            Collections.reverse(path); 
            return new MazeResult(path, visitada);
        }

        return new MazeResult(new ArrayList<>(), visitada);
    }

    private boolean findPath(Cell current) {
        if (!isInMaze(current)) 
            return false;
        if (!isValid(current)) 
            return false;

        path.add(current);
        visitada.add(current);

        if (current.equals(end)) 
            return true;

        // Moverse en las cuatro direcciones
        if (
            findPath(new Cell(current.row, current.col + 1)) || // derecha
            findPath(new Cell(current.row + 1, current.col)) || // abajo
            findPath(new Cell(current.row, current.col - 1)) || // izquierda
            findPath(new Cell(current.row - 1, current.col))    // arriba
        ) {
            return true;
        }

        // Backtrack: desmarcar del camino (opcional si solo se guarda el camino correcto)
        path.remove(path.size() - 1);
        return false;
    }

    private boolean isValid(Cell current) {
        int row = current.row;
        int col = current.col;
        return grid[row][col] && !visitada.contains(current);
    }

    private boolean isInMaze(Cell current) {
        int row = current.row;
        int col = current.col;
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}