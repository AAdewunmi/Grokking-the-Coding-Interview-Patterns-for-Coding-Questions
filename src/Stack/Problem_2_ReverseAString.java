package Stack;

// Problem Statement: Reverse a String
// LeetCode Question: 344 Reverse String

import java.util.Stack;

public class Problem_2_ReverseAString {
    public String reverseString(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}
