package K_Way_Merge;

// Problem Statement: Kth Smallest Number in M Sorted Lists (medium)
// LeetCode Question:

import java.util.List;
import java.util.PriorityQueue;

public class Problem_2_Kth_Smallest_Number_In_M_Sorted_List {

    class Node {
        int elementIndex;
        int arrayIndex;

        Node(int elementIndex, int arrayIndex) {
            this.elementIndex = elementIndex;
            this.arrayIndex = arrayIndex;
        }
    }

    public int findKthSmallest(List<List<Integer>> lists, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(
                (n1, n2) -> lists.get(n1.arrayIndex).get(n1.elementIndex)
                        - lists.get(n2.arrayIndex).get(n2.elementIndex));

        // put the 1st element of each list in the min heap
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.add(new Node(0, i));
            }
        }

        // take the smallest (top) element from the min heap, if the running count is equal
        // to k, return the number; if the list of the top element has more elements, add the
        // next element to the heap
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = lists.get(node.arrayIndex).get(node.elementIndex);
            if (++numberCount == k) {
                break;
            }
            node.elementIndex++;
            if (node.elementIndex < lists.get(node.arrayIndex).size()) {
                minHeap.add(node);
            }
        }
        return result;
    }

}
