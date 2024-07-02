package Cyclic_Sort;

// Problem Statement: Cyclic Sort (easy)
// LeetCode Question: 912. Sort an Array

public class Problem_1_CyclicSort {

    public int[] sortArray(int[] nums){
        int i = 0;
        while (i < nums.length){
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
