package K_Way_Merge;

// Problem Statement: Kth Smallest Number in a Sorted Matrix (hard)
// LeetCode Question: 378. Kth Smallest Element in a Sorted Matrix

import java.util.PriorityQueue;

public class Problem_3_Kth_Smallest_Number_In_A_Sorted_Matrix {

    class Node {
        int row;
        int col;
        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int findKthSmallest(int[][] matrix, int k){
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1 , n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
        for (int i = 0; i < matrix.length && i < k; i++) minHeap.add(new Node(i, 0));

        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++numberCount == k) break;
            node.col++;
            if (matrix[0].length > node.col) minHeap.add(node);
        }
        return result;
    }

}
