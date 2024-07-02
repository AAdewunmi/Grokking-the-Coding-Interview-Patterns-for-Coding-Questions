package Island_Matrix_Traversal;

// Problem Statement: Problem Challenge 2 (medium) - Write a function to find the number of distinct islands in the given matrix.
// LeetCode Question: 694. Number of Distinct Islands

import java.util.HashSet;
import java.util.Set;

public class Problem_6_Number_Of_Distinct_Islands {
    public int findDistinctIslandsDFS(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<String> islandSet = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    StringBuilder islandTraversal = new StringBuilder();
                    traverseIslandDFS(matrix, visited, i, j, islandTraversal, "O");
                    islandSet.add(islandTraversal.toString());
                }
            }
        }
        return islandSet.size();
    }

    private static void traverseIslandDFS(int[][] matrix, boolean[][] visited, int x, int y, StringBuilder islandTraversal, String direction){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return;
        if(matrix[x][y] == 0 || visited[x][y]) return;
        visited[x][y] = true;
        islandTraversal.append(direction);
        traverseIslandDFS(matrix, visited, x + 1, y, islandTraversal, "D");
        traverseIslandDFS(matrix, visited, x - 1, y, islandTraversal, "U");
        traverseIslandDFS(matrix, visited, x, y + 1, islandTraversal, "R");
        traverseIslandDFS(matrix, visited, x, y - 1, islandTraversal, "L");
        islandTraversal.append("B");
    }
}
