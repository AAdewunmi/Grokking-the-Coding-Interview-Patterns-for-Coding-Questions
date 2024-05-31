package Monotonic_Stack;

// Problem Statement: Remove All Adjacent Duplicates In String
// LeetCode Question: 1047. Remove All Adjacent Duplicates In String

public class Problem_4_Remove_All_Adjacent_Duplicates_In_String {
    public String removeDuplicates(String s){
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            int length = stack.length();
            if (length > 0 && c == stack.charAt(length - 1)) {
                stack.deleteCharAt(length - 1);
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}
