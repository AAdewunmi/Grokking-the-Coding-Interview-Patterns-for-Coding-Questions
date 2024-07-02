package Sliding_Window;

// Problem Statement: Longest Substring with Same Letters after Replacement (hard)
// LeetCode Question: 424. Longest Repeating Character Replacement

import java.util.HashMap;
import java.util.Map;

public class Problem_5_LongestSubstringWithSameLettersAfterReplacement {
    public int findLength(String string,  int k){
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < string.length(); windowEnd++) {
            char rightChar = string.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = string.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
