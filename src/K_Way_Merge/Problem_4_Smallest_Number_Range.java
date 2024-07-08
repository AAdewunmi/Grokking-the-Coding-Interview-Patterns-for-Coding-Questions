package K_Way_Merge;

// Problem Statement: Smallest Number Range (hard)
// LeetCode Question: 632. Smallest Range Covering Elements from K Lists

import java.util.List;
import java.util.PriorityQueue;

public class Problem_4_Smallest_Number_Range {

    class Node {
        int elementsIndex;
        int arrayIndex;

        public Node(int elementsIndex, int arrayIndex) {
            this.elementsIndex = elementsIndex;
            this.arrayIndex = arrayIndex;
        }
    }

    public int[] findSmallestRange(List<List<Integer>> lists){
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
                (n1, n2) -> lists.get(n1.arrayIndex).get(n1.elementsIndex) -
                        lists.get(n2.arrayIndex).get(n2.elementsIndex));
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE, currentMaxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                minHeap.add(new Node(0, i));
                currentMaxNumber = Math.max(currentMaxNumber, lists.get(i).get(0));
            }
        }
        while (minHeap.size() == lists.size()) {
            Node node = minHeap.poll();
            if (rangeEnd - rangeStart >
                    currentMaxNumber - lists.get(node.arrayIndex).get(node.elementsIndex)) {
                rangeStart = lists.get(node.arrayIndex).get(node.elementsIndex);
                rangeEnd = currentMaxNumber;
            }
            node.elementsIndex++;
            if (lists.get(node.arrayIndex).size() > node.elementsIndex) {
                minHeap.add(node); // insert the next element in the heap
                currentMaxNumber = Math.max(currentMaxNumber,
                        lists.get(node.arrayIndex).get(node.elementsIndex));
            }
        }
        return new int[] {rangeStart, rangeEnd};
    }
}
