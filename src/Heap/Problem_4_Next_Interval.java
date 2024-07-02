package Heap;

// Problem Statement: Next Interval (hard)
// LeetCode Question: 436. Find Right Interval

import java.util.PriorityQueue;

public class Problem_4_Next_Interval {

    class Interval {
        int start = 0;
        int end = 0;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[] findNextInterval(Interval[] intervals) {
        int n = intervals.length;
        // heap for finding the maximum start
        PriorityQueue<Integer> maxStartHeap =
                new PriorityQueue<>(n, (i1, i2) -> intervals[i2].start - intervals[i1].start);
        // heap for finding the minimum end
        PriorityQueue<Integer> maxEndHeap =
                new PriorityQueue<>(n, (i1, i2) -> intervals[i2].end - intervals[i1].end);
        int[] result = new int[n];
        for (int i = 0; i < intervals.length; i++) {
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        // go through all the intervals to find each interval's next interval
        for (int i = 0; i < n; i++) {
            // let's find the next interval of the interval which has the highest 'end'
            int topEnd = maxEndHeap.poll();
            result[topEnd] = -1; // defaults to -1
            if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                int topStart = maxStartHeap.poll();
                // find the the interval that has the closest 'start'
                while (!maxStartHeap.isEmpty()
                        && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                // put the interval back as it could be the next interval of other intervals
                maxStartHeap.add(topStart);
            }
        }
        return result;
    }
}
