package Stack;

// Problem Statement: Sorting a Stack
// LeetCode Question: -

import java.util.Stack;

public class Problem_5_SortingAStack {
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while (!input.isEmpty()) {
            int tmp = input.pop();
            while(!tmpStack.empty() && tmpStack.peek() > tmp) {
                input.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
        }
        return tmpStack;
    }
}
