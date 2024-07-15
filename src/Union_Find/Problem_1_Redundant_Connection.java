package Union_Find;

// Problem Statement: Redundant Connection (medium)
// LeetCode Question: 684. Redundant Connection

public class Problem_1_Redundant_Connection {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            if (find(node1) == find(node2)) { 
                return edge;
            }
            union(node1, node2);
        }

        return new int[2];
    }

    private int find (int node) {
        if (node != parent[node]) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    private void union (int node1, int node2) {
        parent[find(node1)] = find(node2);
    }

}
