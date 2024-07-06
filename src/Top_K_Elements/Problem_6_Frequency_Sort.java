package Top_K_Elements;

// Problem Statement: Frequency Sort (medium)
// LeetCode Question: 451. Sort Characters By Frequency

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_6_Frequency_Sort {
    public String sortCharacterByFrequency(String str) {

        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for (char chr : str.toCharArray()) {
            characterFrequencyMap.put(chr, characterFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<Map.Entry<Character, Integer>>(
                        (e1, e2) -> e2.getValue() - e1.getValue());

        maxHeap.addAll(characterFrequencyMap.entrySet());

        StringBuilder sortedString = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++)
                sortedString.append(entry.getKey());
        }
        return sortedString.toString();
    }
}
