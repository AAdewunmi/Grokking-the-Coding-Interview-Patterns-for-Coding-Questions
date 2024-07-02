package Two_Pointers;

// Problem Statement: Quadruple Sum to Target (medium)
// LeetCode Question: 18. 4Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_9_Quadruple_Sum_to_Target {
    public List<List<Integer>> searchQuadruples(int[] arr, int target){
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }
                searchPairs(arr, target, i, j, quadruplets);
            }
        }
        return quadruplets;
    }

    private static void searchPairs(int[] arr, int targetSum, int first, int second, List<List<Integer>> quadruplets){
        int left = second + 1;
        int right = arr.length - 1;
        while(left < right){
            int sum = arr[first] + arr[second] + arr[left] + arr[right];
            if (sum == targetSum) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;
                while(left < right && arr[left] == arr[left - 1]){
                    left++;
                }
                while(left < right && arr[right] == arr[right + 1]){
                    right--;
                }
            } else if (sum < targetSum) {
                left++;
            }else {
                right--;
            }
        }
    }


}
