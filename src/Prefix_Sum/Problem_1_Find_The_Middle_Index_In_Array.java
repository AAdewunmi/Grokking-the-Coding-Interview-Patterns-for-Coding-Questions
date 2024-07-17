package Prefix_Sum;

// Problem Statement: Find the Middle Index in Array (easy)
// LeetCode Question: 1991. Find the Middle Index in Array

public class Problem_1_Find_The_Middle_Index_In_Array {
    public int findMiddleIndex(int[] nums){
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return - 1;
    }
}
