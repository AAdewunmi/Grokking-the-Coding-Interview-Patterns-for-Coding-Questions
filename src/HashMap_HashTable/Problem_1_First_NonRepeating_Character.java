package HashMap_HashTable;

// Problem Statement: First Non-repeating Character (easy)
// LeetCode Question: 387. First Unique Character in a String

import java.util.HashMap;

public class Problem_1_First_NonRepeating_Character {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return - 1;
    }
}
