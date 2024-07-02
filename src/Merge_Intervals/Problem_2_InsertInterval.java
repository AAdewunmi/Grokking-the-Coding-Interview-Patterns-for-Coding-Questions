package Merge_Intervals;

// Problem Statement: Insert Interval (medium)
// LeetCode Question: 57. Insert Interval

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_2_InsertInterval {

    class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty()) {
            return Arrays.asList(newInterval);
        }
        List<Interval> mergedIntervals = new ArrayList<>();
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            mergedIntervals.add(intervals.get(i++));
        }
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        mergedIntervals.add(newInterval);
        while(i < intervals.size()){
            mergedIntervals.add(intervals.get(i++));
        }
        return mergedIntervals;
    }

}
