package Union_Find;

// Problem Statement: Path With Minimum Effort (medium)
// LeetCode Question: 1631. Path With Minimum Effort

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_4_Path_With_Minimum_Effort {

    class UnionFind {
        int[] parent;
        int[] rank;

        // Initialize the parent and rank arrays
        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;  // Each element starts as its own parent
                rank[i] = 0;    // Initialize rank to 0
            }
        }

        // Find the root of x with path compression
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);  // Path compression: Set parent to the root
            }
            return parent[x];
        }

        // Union two subsets if they're different
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;  // Attach rootY to rootX if rootX has higher rank
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;  // Attach rootX to rootY if rootY has higher rank
                } else {
                    parent[rootY] = rootX;  // Attach rootY to rootX if ranks are equal
                    rank[rootX]++;         // Increase rank of rootX
                }
            }
        }
    }

    // Edge Class to store the difference between two points
    class Edge {
        int x;
        int y;
        int difference;

        Edge(int x, int y, int difference) {
            this.x = x;
            this.y = y;
            this.difference = difference;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        UnionFind unionFind = new UnionFind(row * col);
        List<Edge> edges = new ArrayList<>();

        // Create all possible edges with the corresponding difference
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (i > 0) {
                    edges.add(new Edge(i * col + j, (i - 1) * col + j, Math.abs(heights[i][j] - heights[i - 1][j])));
                }
                if (j > 0) {
                    edges.add(new Edge(i * col + j, i * col + (j - 1), Math.abs(heights[i][j] - heights[i][j - 1])));
                }
            }
        }

        // Sort edges by their difference
        Collections.sort(edges, (a, b) -> a.difference - b.difference);

        // Perform union-find operations
        for (Edge edge : edges) {
            unionFind.union(edge.x, edge.y);
            if (unionFind.find(0) == unionFind.find(row * col - 1)) {
                // If start and end points are connected, return the current edge's difference
                return edge.difference;
            }
        }
        return 0;
    }

}
