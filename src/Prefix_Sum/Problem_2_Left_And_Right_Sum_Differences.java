package Prefix_Sum;

// Problem Statement: Left and Right Sum Differences (easy)
// LeetCode Question: 2574. Left and Right Sum Differences

public class Problem_2_Left_And_Right_Sum_Differences {
   public int[] findDifferenceArray(int[] nums){
       int n = nums.length;
       int[] leftSum = new int[n];
       int[] rightSum = new int[n];
       int[] differenceArray = new int[n];

       leftSum[0] = nums[0];
       for (int i = 1; i < n; i++) {
           leftSum[i] = leftSum[i - 1] + nums[i];
       }

       rightSum[n - 1] = nums[n - 1];
       for (int i = n - 2; i >= 0 ; i--) {
           rightSum[i] = rightSum[i + 1] + nums[i];
       }

       for (int i = 0; i < n; i++) {
           differenceArray[i] = Math.abs(leftSum[i] - rightSum[i]);
       }
       
       return differenceArray;
   }
}
