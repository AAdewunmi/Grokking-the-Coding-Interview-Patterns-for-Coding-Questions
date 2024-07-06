package Top_K_Elements;

// Problem Statement: 'K' Closest Points to the Origin (easy)
// LeetCode Question: 973. K Closest Points to Origin

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem_3_K_Closest_Points_To_The_Origin {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distFromOrigin() {
            return (x * x) + (y * y);
        }
    }

    public List<Point> findClosestPoints(Point[] points, int k) {
        PriorityQueue<Point> maxHeap =
                new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());
        for (int i = 0; i < k; i++)
            maxHeap.add(points[i]);

        for (int i = k; i < points.length; i++) {
            if (points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
