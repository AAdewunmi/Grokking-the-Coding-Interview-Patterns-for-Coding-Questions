package Merge_Intervals;

// Problem Statement: Minimum Meeting Rooms (hard)
// LeetCode Question: 253. Meeting Rooms 11

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problem_5_MinimumMeetingRooms {
    class Meeting {
        int start;
        int end;

        public Meeting (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int findMinimumMeetingRooms(List<Meeting> meetings){
        if (meetings == null || meetings.size() == 0) {
            return 0;
        }
        Collections.sort(meetings, (a,b) -> Integer.compare(a.start, b.start));
        int minRooms = 0;
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), (a,b) -> Integer.compare(a.end, b.end));
        for(Meeting meeting : meetings){
            while(!minHeap.isEmpty() && meeting.start >= minHeap.peek().end){
                minHeap.poll();
            }
            minHeap.offer(meeting);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }
}
