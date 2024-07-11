package Backtracking;

// Problem Statement: Split a String Into the Max Number of Unique Substrings (medium)
// LeetCode Question: 1593. Split a String Into the Max Number of Unique Substrings

import java.util.HashSet;
import java.util.Set;

public class Problem_5_Split_A_String_Into_Max_Number_Of_Unique_Substrings {
    public int maxUniqueSplit(String s){
        return splitAndCount(s, 0, new HashSet<>());
    }

    private int splitAndCount(String s, int start, Set<String> set){
        if (start == s.length()) {
            return set.size();
        }
        int count = 0;
        for (int i = start + 1; i < s.length(); i++) {
            String string = s.substring(start, i);
            if (set.add(string)) {
                count = Math.max(count, splitAndCount(s, i, set));
                set.remove(string);
            }
        }
        return count;
    }
}
