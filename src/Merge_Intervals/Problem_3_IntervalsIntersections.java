package Merge_Intervals;

// Problem Statement: Intervals Intersection (medium)
// LeetCode Question: 986. Interval List Intersections

import java.util.ArrayList;
import java.util.List;

public class Problem_3_IntervalsIntersections {

    class Interval{
        int start = 0;
        int end = 0;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> merge (Interval[] arr1, Interval[] arr2){
        List<Interval> result = new ArrayList<Interval>();
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length){
            if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end) ||
                    (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)) {
                result.add(new Interval(Math.max(arr1[i].start, arr2[j].start),
                        Math.min(arr1[i].end, arr2[j].end)));
            }
            if (arr1[i].end < arr2[j].end) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
