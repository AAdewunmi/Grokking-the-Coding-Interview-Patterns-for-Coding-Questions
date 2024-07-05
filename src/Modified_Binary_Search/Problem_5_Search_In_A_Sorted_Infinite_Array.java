package Modified_Binary_Search;

// Problem Statement: Search in a Sorted Infinite Array (medium)
// LeetCode Question: 702. Search in a Sorted Array of Unknown Size

public class Problem_5_Search_In_A_Sorted_Infinite_Array {

    class ArrayReader {
        int[] arr;
        ArrayReader(int[] arr) {
            this.arr = arr;
        }
        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
                return arr[index];
        }
    }

    public static int searchInfiniteSortedArray(ArrayReader reader, int key){
        int start = 0, end = 1;
        while (reader.get(end) < key) {
            int newStart = end + 1;
            end += (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(reader, key, start, end);
    }

    private static int binarySearch (ArrayReader reader, int key, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < reader.get(mid)) {
                end = mid - 1;
            } else if (key > reader.get(mid)) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return - 1;
    }

}
