package Cyclic_Sort;

// Problem Statement: Find the Smallest Missing Positive Number (medium)
// LeetCode Question: 41. First Missing Positive

public class Problem_7_FindSmallestMissingPositiveNumber {
    public int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length){
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }else {
                i++;
            }
        }
        for(i = 0; i < nums.length; i++){
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
