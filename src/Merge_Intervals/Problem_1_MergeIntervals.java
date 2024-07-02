package Merge_Intervals;

// Problem Statement: Merge Intervals (medium)
// LeetCode Question: 56. Merge Intervals

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem_1_MergeIntervals {

    class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> merge (List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;
        while(intervalItr.hasNext()){
            interval = intervalItr.next();
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }
}
