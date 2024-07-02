package Cyclic_Sort;

// Problem Statement: Find the Duplicate Number (easy)
// LeetCode Question: 287. Find the Duplicate Number

public class Problem_4_FindTheDuplicateNumber {
    public int findNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                }else{
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    private static void swap (int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
