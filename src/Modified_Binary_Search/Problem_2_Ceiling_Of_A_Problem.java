package Modified_Binary_Search;

// Problem Statement: Ceiling of a Number
// LeetCode Question:

public class Problem_2_Ceiling_Of_A_Problem {
    public static int searchCeilingOfANumber(int[] arr, int key){
        if (key > arr[arr.length - 1]) return -1;
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (key < arr[mid]){
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
