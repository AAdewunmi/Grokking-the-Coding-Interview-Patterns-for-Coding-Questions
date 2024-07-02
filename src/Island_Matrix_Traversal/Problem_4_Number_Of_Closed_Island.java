package Island_Matrix_Traversal;

// Problem Statement: Number of Closed Islands (easy)
// LeetCode Question: 1254. Number of Closed Islands

public class Problem_4_Number_Of_Closed_Island {
    public int countClosedIslands(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int countClosedIslands = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]){
                    if (isClosedIslandDFS(matrix, visited, i, j)){
                        countClosedIslands++;
                    }
                }
            }
        }
        return countClosedIslands;
    }

    private static boolean isClosedIslandDFS(int[][] matrix, boolean[][] visited, int x, int y){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return false;
        if(matrix[x][y] == 0 || visited[x][y]) return true;
        visited[x][y] = true;
        Boolean isClosed = true;
        isClosed &= isClosedIslandDFS(matrix, visited, x + 1, y);
        isClosed &= isClosedIslandDFS(matrix, visited, x - 1, y);
        isClosed &= isClosedIslandDFS(matrix, visited, x, y + 1);
        isClosed &= isClosedIslandDFS(matrix, visited, x, y - 1);
        return isClosed;
    }
}
