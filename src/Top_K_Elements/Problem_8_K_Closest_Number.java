package Top_K_Elements;

// Problem Statement: 'K' Closest Numbers (medium)
// LeetCode Question: 658. Find K Closest Elements

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problem_8_K_Closest_Number {

    class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        int index = binarySearch(arr, X);
        int low = index - K, high = index + K;
        low = Math.max(low, 0); // 'low' should not be less than zero
        // 'high' should not be greater the size of the array
        high = Math.min(high, arr.length - 1);

        PriorityQueue<Entry> minHeap = new PriorityQueue<>((n1, n2) -> n1.key - n2.key);
        // add all candidate elements to the min heap, sorted by their absolute difference
        // from 'X'
        for (int i = low; i <= high; i++)
            minHeap.add(new Entry(Math.abs(arr[i] - X), i));

        // we need the top 'K' elements having smallest difference from 'X'
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < K; i++)
            result.add(arr[minHeap.poll().value]);

        Collections.sort(result);
        return result;
    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low > 0) {
            return low - 1;
        }
        return low;
    }

}
