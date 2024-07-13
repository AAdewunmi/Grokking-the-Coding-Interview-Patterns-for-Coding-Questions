package Topological_Sort;

// Problem Statement: All Tasks Scheduling Orders (hard)
// LeetCode Question:


import java.util.*;

public class Problem_4_All_Tasks_Scheduling_Orders {

    List<List<Integer>> orders;
    public Problem_4_All_Tasks_Scheduling_Orders() {
        orders = new ArrayList<List<Integer>>();
    }

    public List<List<Integer>> printOrders(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (tasks <= 0)
            return orders;

        // a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        // b. Build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child); // put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        printAllTopologicalSorts(graph, inDegree, sources, sortedOrder);

        // Do not modify this
        return orders;
    }

    private void printAllTopologicalSorts(HashMap<Integer, List<Integer>> graph,
                                          HashMap<Integer, Integer> inDegree, Queue<Integer> sources,
                                          List<Integer> sortedOrder) {

        if (!sources.isEmpty()) {
            for (Integer vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(sources);
                // only remove the current source, all other sources should remain in the queue
                // for the next call
                sourcesForNextCall.remove(vertex);
                // get the node's children to decrement their in-degrees
                List<Integer> children = graph.get(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0)
                        sourcesForNextCall.add(child); // save the new source for the next call
                }

                // recursive call to print other orderings from the remaining (and new) sources
                printAllTopologicalSorts(graph, inDegree, sourcesForNextCall, sortedOrder);

                // backtrack, remove the vertex from the sorted order and put all of its
                // children back to consider  the next source instead of the current vertex
                sortedOrder.remove(vertex);
                for (int child : children)
                    inDegree.put(child, inDegree.get(child) + 1);
            }
        }

        // if sortedOrder doesn't contain all tasks, either we've a cyclic dependency
        // between tasks, or we have not processed all the tasks in this recursive call
        if (sortedOrder.size() == inDegree.size())  {
            List<Integer> copy = new ArrayList<>(sortedOrder);
            orders.add(copy);
        };
    }

    // makes a deep copy of the queue
    private Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
            clone.add(num);
        return clone;
    }
}
