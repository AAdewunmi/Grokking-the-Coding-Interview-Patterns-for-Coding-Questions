package Graph;

// Problem Statement: Find if Path Exists in Graph (easy)
// LeetCode Question: 1971. Find if Path Exists in Graph

import java.util.ArrayList;
import java.util.List;

public class Problem_1_Find_If_Path_Exists_In_Graph {

    private boolean[] visited;

    public boolean validPath(int n, int[][] edges, int start, int end){
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        visited = new boolean[n];
        return dfs(graph, start, end);
    }

    private boolean dfs (List<List<Integer>> graph, int node, int end) {
        if (node == end) return true;
        visited[node] = true;
        for (int neighbor : graph.get(node)){
            if (!visited[neighbor] && dfs(graph, neighbor, end)) {
                return true;
            }
        }
        return false;
    }
}
