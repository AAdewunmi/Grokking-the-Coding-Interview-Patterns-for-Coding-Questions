package Island_Matrix_Traversal;

// Problem Statement: Number of Islands (easy)
// LeetCode Question: 200. Number of Islands

public class Problem_1_Number_Of_Islands {
    // Depth First Approach

    public int countIslands(int[][] matrix){

        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    totalIslands++;
                    visitIslandDFS(matrix, i, j);
                }
            }
        }
        return totalIslands;
    }

    private static void visitIslandDFS(int[][] matrix, int x, int y){
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return;
        if (matrix[x][y] == 0) return;
        matrix[x][y] = 0;
        visitIslandDFS(matrix, x + 1, y);
        visitIslandDFS(matrix, x - 1, y);
        visitIslandDFS(matrix, x, y + 1);
        visitIslandDFS(matrix, x, y - 1);
    }
}
