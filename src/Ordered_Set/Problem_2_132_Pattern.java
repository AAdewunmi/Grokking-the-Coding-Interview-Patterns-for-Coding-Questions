package Ordered_Set;

// Problem Statement: Merge Similar Items (easy)
// LeetCode Question: 2363. Merge Similar Items

import java.util.Stack;

public class Problem_2_132_Pattern {
    public boolean find132pattern(int[] nums) {
        int z = Integer.MIN_VALUE; // Initialize z to the smallest possible value
        Stack<Integer> stack = new Stack<>(); // Use a stack to simulate an ordered set

        // Iterate backwards through the list
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < z) {
                return true; // A '132' pattern is found
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                z = stack.pop(); // Update z to the largest smaller element
            }
            stack.push(nums[i]); // Add the current number to the stack
        }

        return false;
    }
}
