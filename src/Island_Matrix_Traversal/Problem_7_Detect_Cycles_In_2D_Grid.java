package Island_Matrix_Traversal;

// Problem Statement: Problem Challenge 3 (medium) - Write a function to find the number of distinct islands in the given matrix.
// LeetCode Question: 1559. Detect Cycles in 2D Grid

public class Problem_7_Detect_Cycles_In_2D_Grid {
    public boolean hasCycle(char[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) // only if the cell is not visited
                    if (containsCycleDFS(matrix, visited, matrix[i][j], i, j, -1, -1))
                        return true;
            }
        }
        return false;
    }

    private static boolean containsCycleDFS(char[][] matrix, boolean[][] visited, char startChar, int x, int y, int prevX, int prevY){
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return false;
        if (matrix[x][y] != startChar) return false;
        if (visited[x][y]) return true;
        visited[x][y] = true;
        if (x + 1 != prevX && containsCycleDFS(matrix, visited, startChar, x + 1, y, x, y)) // down
            return true;
        if (x - 1 != prevX && containsCycleDFS(matrix, visited, startChar, x - 1, y, x, y)) // up
            return true;
        if (y + 1 != prevY && containsCycleDFS(matrix, visited, startChar, x, y + 1, x, y)) // right
            return true;
        if (y - 1 != prevY && containsCycleDFS(matrix, visited, startChar, x, y - 1, x, y)) // left
            return true;

        return false;
    }
}
