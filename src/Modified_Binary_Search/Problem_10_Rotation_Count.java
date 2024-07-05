package Modified_Binary_Search;

// Problem Statement: Rotation Count (medium)
// LeetCode Question: 153. Find Minimum in Rotated Sorted Array

public class Problem_10_Rotation_Count {
    public int countRotations(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            // if mid is greater than the next element
            if (mid < end && arr[mid] > arr[mid + 1])
                return mid + 1;

            // if mid is smaller than the previous element
            if (mid > start && arr[mid - 1] > arr[mid])
                return mid;

            if (arr[start] < arr[mid]) { // left side is sorted, so the pivot is on right side
                start = mid + 1;
            } else { // right side is sorted, so the pivot is on the left side
                end = mid - 1;
            }
        }
        return 0; // the array has not been rotated
    }
}
