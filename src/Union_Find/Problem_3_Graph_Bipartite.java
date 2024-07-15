package Union_Find;

// Problem Statement: Is Graph Bipartite? (medium)
// LeetCode Question: 785. Is Graph Bipartite?

public class Problem_3_Graph_Bipartite {
    private int[] parent;

    public boolean isBipartite(int[][] graph) {
        parent = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            parent[i] = i;
        }
        for (int u = 0; u < graph.length; u++) {
            if (graph[u].length == 0) continue; // No edges for this node
            int parentU = find(u); // Find the parent set for u
            int firstNeighbor = graph[u][0]; // Take the first neighbor

            // Union the rest of u's neighbors to the first neighbor's set
            for (int v : graph[u]) {
                if (parentU == find(v)) return false; // If u and v belong to the same set
                union(firstNeighbor, v); // Union v with the first neighbor
            }
        }
        return true;
    }

    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }

    private void union(int node1, int node2) {
        parent[find(node1)] = find(node2); // Union by updating the parent
    }
}
