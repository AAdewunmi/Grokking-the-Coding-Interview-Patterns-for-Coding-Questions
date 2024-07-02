package Merge_Intervals;

// Problem Statement: Conflicting Appointments (medium)
// LeetCode Question: 1353. Maximum Number of Events That Can Be Attended

import java.util.Arrays;

public class Problem_4_ConflictingAppointments {
    class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }

}
