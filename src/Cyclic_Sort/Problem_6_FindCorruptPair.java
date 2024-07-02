package Cyclic_Sort;

// Problem Statement: Find the Corrupt Pair (easy)
// LeetCode Question: 645. Set Mismatch

public class Problem_6_FindCorruptPair {
    public int[] findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length ) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[] {nums[i], i + 1};
            }
        }
        return new int[] { -1, -1 };
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
