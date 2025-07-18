package models;

import java.util.*;

public interface MazeSolver {

    MazeResult getPath(boolean[][] grid, Cell start, Cell end);
}
