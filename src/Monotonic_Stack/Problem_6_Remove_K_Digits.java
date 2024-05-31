package Monotonic_Stack;

// Problem Statement: Remove K Digits (hard)
// LeetCode Question: 402. Remove K Digits

import java.util.Stack;

public class Problem_6_Remove_K_Digits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()){
            while(k > 0 && !stack.isEmpty() && stack.peek() > digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}
