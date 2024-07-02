package HashMap_HashTable;

// Problem Statement: Longest Palindrome(easy)
// LeetCode Question: 409. Longest Palindrome

import java.util.HashMap;

public class Problem_4_Longest_Palindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int length = 0;
        boolean oddFound = false;
        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                length += freq;
            } else {
                length += freq - 1;
                oddFound = true;
            }
        }
        if(oddFound) length++;
        return length;
    }
}
