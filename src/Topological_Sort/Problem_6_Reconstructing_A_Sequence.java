package Topological_Sort;

// Problem Statement: Reconstructing a Sequence (hard)
// LeetCode Question: 444. Sequence Reconstruction

import java.util.*;

public class Problem_6_Reconstructing_A_Sequence {

        public boolean canConstruct(int[] originalSeq, int[][] sequences) {
            List<Integer> sortedOrder = new ArrayList<>();
            if (originalSeq.length <= 0)
                return false;

            // a. Initialize the graph
            HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
            HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
            for (int[] seq : sequences) {
                for (int i = 0; i < seq.length; i++) {
                    inDegree.putIfAbsent(seq[i], 0);
                    graph.putIfAbsent(seq[i], new ArrayList<Integer>());
                }
            }

            // b. Build the graph
            for (int[] seq : sequences) {
                for (int i = 1; i < seq.length; i++) {
                    int parent = seq[i - 1], child = seq[i];
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                }
            }

            // if we don't have ordering rules for all the numbers we'll not able to uniquely
            // construct the sequence
            if (inDegree.size() != originalSeq.length)
                return false;

            // c. Find all sources i.e., all vertices with 0 in-degrees
            Queue<Integer> sources = new LinkedList<>();
            for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
                if (entry.getValue() == 0)
                    sources.add(entry.getKey());
            }

            // d. For each source, add it to the sortedOrder and subtract one from all of its
            // children's in-degrees if a child's in-degree becomes zero, add it to sources queue
            while (!sources.isEmpty()) {
                if (sources.size() > 1)
                    return false; // more than one sources mean, there is more than one way to
                // reconstruct the sequence
                if (originalSeq[sortedOrder.size()] != sources.peek())
                    return false; // the next source (or number) is different from original sequence
                int vertex = sources.poll();
                sortedOrder.add(vertex);
                // get the node's children to decrement their in-degrees
                List<Integer> children = graph.get(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0)
                        sources.add(child);
                }
            }

            // if sortedOrder's size is not equal to original sequence's size, there is no
            // unique way to construct
            return sortedOrder.size() == originalSeq.length;
        }

}
