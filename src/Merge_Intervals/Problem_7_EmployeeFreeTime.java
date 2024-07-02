package Merge_Intervals;

// Problem Statement: Employee Free Time
// LeetCode Question: 759. Employee Free Time

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem_7_EmployeeFreeTime {
    class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    class EmployeeInterval{
        Interval interval;
        int employeeIndex;
        int intervalIndex;

        public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex){
            this.interval = interval;
            this.employeeIndex = employeeIndex;
            this.intervalIndex = intervalIndex;
        }
    }

    public List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule){
        List<Interval> result = new ArrayList<>();
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.interval.start, b.interval.start));
        for (int i = 0; i < schedule.size(); i++) {
            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
        }
        Interval previousInterval = minHeap.peek().interval;
        while (!minHeap.isEmpty()){
            EmployeeInterval queueTop = minHeap.poll();
            if (previousInterval.end < queueTop.interval.start) {
                result.add(new Interval(previousInterval.end, queueTop.interval.start));
                previousInterval = queueTop.interval;
            } else {
                if (previousInterval.end < queueTop.interval.end) {
                    previousInterval = queueTop.interval;
                }
            }
            List<Interval> employeeSchedule = schedule.get(queueTop.employeeIndex);
            if (employeeSchedule.size() > queueTop.intervalIndex + 1) {
                minHeap.offer(new EmployeeInterval(employeeSchedule.get(queueTop.intervalIndex + 1),
                        queueTop.employeeIndex,
                        queueTop.intervalIndex + 1));
            }
        }
        return result;
    }
}
