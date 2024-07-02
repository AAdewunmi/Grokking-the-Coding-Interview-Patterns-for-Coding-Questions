package Stack;

// Problem Statement: Balanced Parentheses
// LeetCode Question: 20. Valid Parentheses

import java.util.Stack;

public class Problem_1_BalancedParentheses {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
