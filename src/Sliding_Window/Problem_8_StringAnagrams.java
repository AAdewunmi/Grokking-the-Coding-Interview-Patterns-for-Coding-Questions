package Sliding_Window;

// Problem Statement: String Anagrams (hard)
// LeetCode Question: 438. Find All Anagrams in a String

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_8_StringAnagrams {
    public List<Integer> findStringAnagrams(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            characterIntegerMap.put(chr, characterIntegerMap.getOrDefault(chr, 0) + 1);
        }
        List<Integer> resultIndices = new ArrayList<Integer>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (characterIntegerMap.containsKey(rightChar)) {
                characterIntegerMap.put(rightChar, characterIntegerMap.get(rightChar) - 1);
                if (characterIntegerMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            if (matched == characterIntegerMap.size()) {
                resultIndices.add(windowStart);
            }
            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (characterIntegerMap.containsKey(leftChar)) {
                    if (characterIntegerMap.get(leftChar) == 0) {
                        matched--;
                    }
                    characterIntegerMap.put(leftChar, characterIntegerMap.get(leftChar) + 1);
                }
            }
        }
        return resultIndices;
    }
}
