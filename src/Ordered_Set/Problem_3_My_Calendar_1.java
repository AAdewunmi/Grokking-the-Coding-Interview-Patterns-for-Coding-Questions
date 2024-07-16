package Ordered_Set;

// Problem Statement: My Calendar I (medium)
// LeetCode Question: 729. My Calendar I

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem_3_My_Calendar_1 {
    private static TreeSet<int[]> bookings = new TreeSet<>((a, b) -> a[0] - b[0]);

    public static List<Boolean> book(int[][] nums) {
        List<Boolean> results = new ArrayList<>();

        for (int[] interval : nums) {
            int start = interval[0];
            int end = interval[1];
            int[] event = new int[] { start, end };
            int[] lower = bookings.lower(event); // Find the closest event that starts before this one
            int[] higher = bookings.higher(event); // Find the closest event that starts after this one

            // Check for overlap with neighboring events
            if ((lower == null || lower[1] <= start) && (higher == null || end <= higher[0])) {
                bookings.add(event); // Add to TreeSet if no overlap
                results.add(true);
            } else {
                results.add(false);
            }
        }
        return results;
    }
}
