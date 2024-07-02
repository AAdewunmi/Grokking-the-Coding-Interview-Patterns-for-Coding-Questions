package Island_Matrix_Traversal;

// Problem Statement: Problem Challenge 1 (easy) - The given matrix has only one island, write a function to find the perimeter of that island.
// LeetCode Question: 463. Island Perimeter

public class Problem_5_Island_Perimeter {
    public int findIslandPerimeter(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    return isPerimeterDFS(matrix, visited, i, j);
                }
            }
        }
        return 0;
    }

    private static int isPerimeterDFS(int[][] matrix, boolean[][] visited, int x, int y){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return 1;
        if(matrix[x][y] == 0) return 1;
        if(visited[x][y]) return 0;
        visited[x][y] = true;
        int edgeCount = 0;
        edgeCount += isPerimeterDFS(matrix, visited, x + 1, y);
        edgeCount += isPerimeterDFS(matrix, visited, x - 1, y);
        edgeCount += isPerimeterDFS(matrix, visited, x, y + 1);
        edgeCount += isPerimeterDFS(matrix, visited, x, y - 1);
        return edgeCount;
    }
}
