package HashMap_HashTable;

// Problem Statement: Ransom Note (easy)
// LeetCode Question: 383. Ransom Note

import java.util.HashMap;

public class Problem_5_Ransome_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        return true;
    }
}
