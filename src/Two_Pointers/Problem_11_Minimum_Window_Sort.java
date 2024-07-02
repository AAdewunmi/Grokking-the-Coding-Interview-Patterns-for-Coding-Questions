package Two_Pointers;

// Problem Statement: Minimum Window Sort (medium)
// LeetCode Question: 581. Shortest Unsorted Continuous Subarray

public class Problem_11_Minimum_Window_Sort {
    public static int sort(int[] arr) {
        int low = 0, high = arr.length - 1;
        // find the first number out of sorting order from the beginning
        while (low < arr.length - 1 && arr[low] <= arr[low + 1])
            low++;

        if (low == arr.length - 1) // if the array is sorted
            return 0;

        // find the first number out of sorting order from the end
        while (high > 0 && arr[high] >= arr[high - 1])
            high--;

        // find the maximum and minimum of the subarray
        int subarrayMax = Integer.MIN_VALUE, subarrayMin = Integer.MAX_VALUE;
        for (int k = low; k <= high; k++) {
            subarrayMax = Math.max(subarrayMax, arr[k]);
            subarrayMin = Math.min(subarrayMin, arr[k]);
        }

        // extend the subarray to include any number which is bigger than the minimum of
        // the subarray
        while (low > 0 && arr[low - 1] > subarrayMin)
            low--;
        // extend the subarray to include any number which is smaller than the maximum of
        // the subarray
        while (high < arr.length - 1 && arr[high + 1] < subarrayMax)
            high++;

        return high - low + 1;
    }
}
