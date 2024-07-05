package Modified_Binary_Search;

// Problem Statement: Next Letter (medium)
// LeetCode Question: 744. Find Smallest Letter Greater Than Target


public class Problem_3_Next_Letter {
    public char searchNextLetter(char[] letters, char key){
        int n = letters.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % n];
    }
}
