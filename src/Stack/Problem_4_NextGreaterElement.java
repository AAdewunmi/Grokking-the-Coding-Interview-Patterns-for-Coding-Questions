package Stack;

// Problem Statement: Next Greater Element
// HackerRank Contest: Next Greater Element (URL: https://www.hackerrank.com/contests/second/challenges/next-greater-element/problem)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Problem_4_NextGreaterElement {
    public List<Integer> nextLargerElement(List<Integer> arr) {
        int n = arr.size();
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= arr.get(i)){
                stack.pop();
            }
            res.add(stack.empty() ? -1 : stack.peek());
            stack.push(arr.get(i));
        }
        Collections.reverse(res);
        return res;
    }
}
