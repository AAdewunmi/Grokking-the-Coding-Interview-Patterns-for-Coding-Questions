package Two_Pointers_Technique;

// Problem Statement: Find Non-Duplicate Number Instances (easy)
// LeetCode Question: 26. Remove Duplicates from Sorted Array

public class Problem_2 {
    public int remove(int[] arr){
        int nextDuplicateItem = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextDuplicateItem - 1] != arr[i]) {
                arr[nextDuplicateItem - 1] = arr[i];
                nextDuplicateItem++;
            }
        }
        return 1;
    }
}
