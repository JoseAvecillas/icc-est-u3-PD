package models;

import java.util.*;

public class MazeResult {
    private final List<Cell> path;
    private final Set<Cell> visitadas;

    public MazeResult(List<Cell> path, Set<Cell> visitadas) {
        this.path = path;
        this.visitadas = visitadas;
    }

    public List<Cell> getPath() {
        return path;
    }

    public Set<Cell> getVisitadas() {
        return visitadas;
    }

    @Override
    public String toString() {
        return "Camino: " + path + "\nVisitadas: " + visitadas;
    }
}