package Modified_Binary_Search;

// Problem Statement: Minimum Difference Element (medium)
// LeetCode Question: 1200. Minimum Absolute Difference

public class Problem_6_Minimum_Difference_Element {
    public static int searchMinDiffElement(int[] arr, int key){
        if (key < arr[0]) {
            return arr[0];
        }
        if (key > arr[arr.length - 1]) {
            return arr[arr.length - 1];
        }
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]){
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }
        if ((arr[start] - key) < (key - arr[end]))
            return arr[start];
        return arr[end];
    }
}
