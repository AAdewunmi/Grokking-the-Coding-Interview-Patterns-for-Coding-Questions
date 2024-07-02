package Island_Matrix_Traversal;

// Problem Statement: Flood Fill (easy)
// LeetCode Question: 733. Flood Fill

public class Problem_3_Flood_Fill {
    public int[][] floodFill(int[][] matrix, int x, int y, int newColor){
        if (matrix[x][y] != newColor) {
            fillDFS(matrix, x, y, matrix[x][y], newColor);
        }
        return matrix;
    }

    private static void fillDFS(int[][] matrix, int x, int y, int oldColor, int newColor){
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return;
        if (matrix[x][y] != oldColor) return;
        matrix[x][y] = newColor;
        fillDFS(matrix, x + 1, y, oldColor, newColor);
        fillDFS(matrix, x - 1, y, oldColor, newColor);
        fillDFS(matrix, x, y + 1, oldColor, newColor);
        fillDFS(matrix, x, y - 1, oldColor, newColor);
    }
}
