package Stack;

// Problem Statement: Simplify Path
// LeetCode Question: 71. Simplify Path

import java.util.Stack;

public class Problem_6_SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String p : path.split("/")) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!p.isEmpty() && !p.equals(".")) {
                stack.push(p);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}
