package Two_Pointers;

// Problem Statement: Pair with Target Sum (easy)
// LeetCode Question: 1. Two Sum

public class Problem_1_Pair_With_Target_Sum {
    public static int[] search(int[] arr, int targetSum){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
               return new int[]{left, right};
            }
            if (currentSum > targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }
}
