package Two_Pointers;

// Problem Statement: Triplets with Smaller Sum (medium)
// LeetCode Question: 259. 3Sum Smaller

import java.util.Arrays;

public class Problem_6_Triplets_with_Smaller_Sum {
    public int searchTriplets(int[] arr, int target){
        if (arr.length < 3) {
            return 0;
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first){
        int count = 0;
        int left = first + 1, right = arr.length - 1;
        while(left < right){
            if(arr[left] + arr[right] < targetSum){
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
