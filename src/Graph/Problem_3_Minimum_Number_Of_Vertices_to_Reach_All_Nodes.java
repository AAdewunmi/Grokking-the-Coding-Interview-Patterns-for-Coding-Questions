package Graph;

// Problem Statement: Minimum Number of Vertices to Reach All Nodes(medium)
// LeetCode Question: 1557. Minimum Number of Vertices to Reach All Nodes

import java.util.ArrayList;
import java.util.List;

public class Problem_3_Minimum_Number_Of_Vertices_to_Reach_All_Nodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges){
        boolean[] hasIncomingEdge = new boolean[n];
        for(List<Integer> edge : edges){
            hasIncomingEdge[edge.get(1)] = true;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!hasIncomingEdge[i]) {
                result.add(i);
            }
        }
        return result;
    }

}
