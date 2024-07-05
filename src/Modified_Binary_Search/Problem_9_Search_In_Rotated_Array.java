package Modified_Binary_Search;

// Problem Statement: Search in Rotated Array (medium)
// LeetCode Question: 33. Search in Rotated Sorted Array

public class Problem_9_Search_In_Rotated_Array {
    class Solution {

        public  int search(int[] arr, int key) {
            int start = 0, end = arr.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == key)
                    return mid;
                if ((arr[start] == arr[mid]) && (arr[end] == arr[mid])) {
                    ++start;
                    --end;
                } else if (arr[start] <= arr[mid]) { // left side is sorted in ascending order
                    if (key >= arr[start] && key < arr[mid]) {
                        end = mid - 1;
                    } else { //key > arr[mid]
                        start = mid + 1;
                    }
                } else { // right side is sorted in ascending order
                    if (key > arr[mid] && key <= arr[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
