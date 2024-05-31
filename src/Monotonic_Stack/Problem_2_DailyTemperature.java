package Monotonic_Stack;

// Problem Statement: Daily Temperatures
// LeetCode Question: 739. Daily Temperatures

import java.util.Stack;

public class Problem_2_DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
}
