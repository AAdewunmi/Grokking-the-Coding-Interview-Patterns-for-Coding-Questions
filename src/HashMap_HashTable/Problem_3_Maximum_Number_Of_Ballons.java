package HashMap_HashTable;

// Problem Statement: Maximum Number of Balloons (easy)
// LeetCode Question: 1189. Maximum Number of Balloons

import java.util.HashMap;

public class Problem_3_Maximum_Number_Of_Ballons {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        int minCount = Integer.MAX_VALUE;
        minCount = Math.min(minCount, charCount.getOrDefault('b', 0));
        minCount = Math.min(minCount, charCount.getOrDefault('a', 0));
        minCount = Math.min(minCount, charCount.getOrDefault('l', 0) / 2);
        minCount = Math.min(minCount, charCount.getOrDefault('o', 0) / 2);
        minCount = Math.min(minCount, charCount.getOrDefault('n', 0));
        return minCount;
    }
}
