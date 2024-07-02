package Sliding_Window;

// Problem Statement: Longest Substring with K Distinct Characters (medium)
// LeetCode Question: 340. Longest Substring With At Most K Distinct Characters

import java.util.HashMap;
import java.util.Map;

public class Problem_3_LongestSubstringWithKDistinctCharacters {

    public int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            while(charFrequencyMap.size() > k){
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
