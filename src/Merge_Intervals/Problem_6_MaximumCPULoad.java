package Merge_Intervals;

// Problem Statement: Maximum CPU Load (hard)
// LeetCode Question: 1235. Maximum Profit in Job Scheduling

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problem_6_MaximumCPULoad {
    class Job {
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad){
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }

        public int findMaxCPULoad(List<Job> jobs){
            Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
            int maxCPULoad = 0;
            int currentCPULoad = 0;
            PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a,b) -> Integer.compare(a.end, b.end));
            for (Job job : jobs){
                while(!minHeap.isEmpty() && job.start > minHeap.peek().end){
                    currentCPULoad -= minHeap.poll().cpuLoad;
                }
                minHeap.offer(job);
                currentCPULoad += job.cpuLoad;
                maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
            }
            return maxCPULoad;
        }
    }
}
