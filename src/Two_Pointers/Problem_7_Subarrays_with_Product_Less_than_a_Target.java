package Two_Pointers;

// Problem Statement: Subarrays with Product Less than a Target (medium)
// LeetCode Question: 713. Subarray Product Less Than K

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem_7_Subarrays_with_Product_Less_than_a_Target {
    public List<List<Integer>> findSubArrays(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        double product = 1;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while(product >= target && left < arr.length){
                product /= arr[left++];
            }
            List<Integer> tempList = new LinkedList<>();
            for (int i = right; i >= left ; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }
}
