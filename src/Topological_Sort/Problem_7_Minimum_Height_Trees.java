package Topological_Sort;

// Problem Statement: Minimum Height Trees (hard)
// LeetCode Question: 310. Minimum Height Trees

import java.util.*;

public class Problem_7_Minimum_Height_Trees {

        public List<Integer> findTrees(int nodes, int[][] edges) {
            List<Integer> minHeightTrees = new ArrayList<>();
            if (nodes <= 0)
                return minHeightTrees;

            // with only one node, since its in-degree will be 0, therefore, we need to handle
            // it separately
            if (nodes == 1) {
                minHeightTrees.add(0);
                return minHeightTrees;
            }

            // a. Initialize the graph
            HashMap<Integer, Integer> inDegree =
                    new HashMap<>(); // count of incoming edges for every vertex
            HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
            for (int i = 0; i < nodes; i++) {
                inDegree.put(i, 0);
                graph.put(i, new ArrayList<Integer>());
            }

            // b. Build the graph
            for (int i = 0; i < edges.length; i++) {
                int n1 = edges[i][0], n2 = edges[i][1];
                // since this is an undirected graph, therefore, add a link for both the nodes
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
                // increment the in-degrees of both the nodes
                inDegree.put(n1, inDegree.get(n1) + 1);
                inDegree.put(n2, inDegree.get(n2) + 1);
            }

            // c. Find all leaves i.e., all nodes with only 1 in-degree
            Queue<Integer> leaves = new LinkedList<>();
            for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
                if (entry.getValue() == 1)
                    leaves.add(entry.getKey());
            }

            // d. Remove leaves level by level and subtract each leave's children's in-degrees.
            // Repeat this until we are left with 1 or 2 nodes, which will be our answer.
            // Any node that has already been a leaf cannot be the root of a minimum height tree,
            // because  its adjacent non-leaf node will always be a better candidate.
            int totalNodes = nodes;
            while (totalNodes > 2) {
                int leavesSize = leaves.size();
                totalNodes -= leavesSize;
                for (int i = 0; i < leavesSize; i++) {
                    int vertex = leaves.poll();
                    List<Integer> children = graph.get(vertex);
                    for (int child : children) {
                        inDegree.put(child, inDegree.get(child) - 1);
                        if (inDegree.get(child) == 1) // if the child has become a leaf
                            leaves.add(child);
                    }
                }
            }

            minHeightTrees.addAll(leaves);
            return minHeightTrees;
        }

}
