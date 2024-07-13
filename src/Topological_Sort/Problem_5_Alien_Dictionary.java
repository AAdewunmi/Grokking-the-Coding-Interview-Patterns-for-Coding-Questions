package Topological_Sort;

// Problem Statement: Alien Dictionary (hard)
// LeetCode Question: 269. Alien Dictionary

import java.util.*;

public class Problem_5_Alien_Dictionary {
    public String findOrder(String[] words) {
        if (words == null || words.length == 0)
            return "";

        // a. Initialize the graph
        HashMap<Character, Integer> inDegree =
                new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Character, List<Character>> graph = new HashMap<>(); // adjacency list graph
        for (String word : words) {
            for (char character : word.toCharArray()) {
                inDegree.put(character, 0);
                graph.put(character, new ArrayList<Character>());
            }
        }

        // b. Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            // find ordering of characters from adjacent words
            String w1 = words[i], w2 = words[i + 1];
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j), child = w2.charAt(j);
                if (parent != child) { // if the two characters are different
                    graph.get(parent).add(child); // put the child into it's parent's list
                    inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
                    break; // only the first different character between the two words will help
                    // us find the order
                }
            }
        }

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Character> sources = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its
        // children's in-degrees if a child's in-degree becomes zero, add it to sources queue
        StringBuilder sortedOrder = new StringBuilder();
        while (!sources.isEmpty()) {
            Character vertex = sources.poll();
            sortedOrder.append(vertex);
            // get the node's children to decrement their in-degrees
            List<Character> children = graph.get(vertex);
            for (Character child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.add(child);
            }
        }

        // if sortedOrder doesn't contain all characters, there is a cyclic dependency
        // between characters, therefore, we  will not be able to find the correct ordering
        // of the characters
        if (sortedOrder.length() != inDegree.size())
            return "";

        return sortedOrder.toString();
    }
}
