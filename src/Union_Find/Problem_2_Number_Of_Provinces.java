package Union_Find;

// Problem Statement: Number of Provinces (medium)
// LeetCode Question: 547. Number of Provinces

public class Problem_2_Number_Of_Provinces {
    private int[] parent;

    public int findProvinces(int[][] isConnected){
        int n = isConnected.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int provinces = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && find(i) != find(j)) {
                    union(i, j);
                    provinces--;
                }
            }
        }
        return provinces;
    }

    private int find (int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    private void union (int i, int j) {
        parent[find(i)] = find(j);
    }
}
