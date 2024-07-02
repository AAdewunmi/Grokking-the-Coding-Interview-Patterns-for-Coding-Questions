package Cyclic_Sort;

// Problem Statement: Find the Missing Number (easy)
// LeetCode Question: 268. Missing Number

public class Problem_2_FindMissingNumber {

    public static int findMissingNumber(int[] nums){
        int i = 0;
        while (i < nums.length){
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return nums.length;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
