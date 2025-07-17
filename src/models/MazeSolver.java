package models;

import java.util.*;

public interface MazeSolver {

    List<Cell> getPath(boolean[][] grid, Cell start, Cell end);
}
