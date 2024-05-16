package Fast_And_Slow_Pointers;

// Problem Statement: Cycle in a Circular Array (hard)
// LeetCode Question: 457. Circular Array Loop

public class Problem_7_CycleInACircularArray {
    public boolean circularArrayLoop(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int slow = i;
                int fast = i;
                boolean isForward = nums[i] >= 0;
                while (true) {
                    slow = findNextIndex(nums, isForward, slow);
                    fast = findNextIndex(nums, isForward, fast);
                    if (fast != -1) {
                        fast = findNextIndex(nums, isForward, fast);
                    }
                    if (fast == -1 || slow == -1 || fast == slow) {
                        break;
                    }
                    visited[slow] = true;
                    visited[fast] = true;
                }
                if (slow != -1 && fast == slow) {
                    return true;
                }
            }
        }
        return false;
    }

    int findNextIndex(int[] arr, boolean isForward, int curr) {
        boolean direction = arr[curr] >= 0;
        if (direction != isForward) {
            return -1;
        }
        int nextIndex = (arr[curr] + curr) % arr.length;
        if (nextIndex < 0) {
            nextIndex += arr.length;
        }
        if (nextIndex == curr) {
            return -1;
        }
        return nextIndex;
    }
}
