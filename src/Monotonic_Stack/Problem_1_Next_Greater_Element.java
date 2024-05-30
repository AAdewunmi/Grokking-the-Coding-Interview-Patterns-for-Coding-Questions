package Monotonic_Stack;

// Problem Statement: Next Greater Element (easy)
// LeetCode Question: 496. Next Greater Element I

import java.util.HashMap;
import java.util.Stack;

public class Problem_1_Next_Greater_Element {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
