package Modified_Binary_Search;

// Problem Statement: Order-agnostic Binary Search (easy)
// LeetCode Question: 704. Binary Search

public class Problem_1_Binary_Search {

    public static int search(int[] arr, int key){
        int start = 0, end = arr.length - 1;
        boolean isAscending = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == arr[mid]) return mid;
            if (isAscending) {
                if (key < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (key > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

}
