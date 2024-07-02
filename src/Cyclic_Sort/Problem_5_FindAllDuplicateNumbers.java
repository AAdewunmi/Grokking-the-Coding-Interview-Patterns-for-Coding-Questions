package Cyclic_Sort;

// Problem Statement: Find the Duplicate Numbers (easy)
// LeetCode Question: 442. Find All Duplicates in an Array

import java.util.ArrayList;
import java.util.List;

public class Problem_5_FindAllDuplicateNumbers {
    public List<Integer> findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        List<Integer> duplicateNumbers = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                duplicateNumbers.add(nums[j]);
            }
        }
        return duplicateNumbers;
    }

    private static void swap (int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
