package Bitwise_XOR;

// Problem Statement: Flip and Invert an Image (hard)
// LeetCode Question: 832. Flipping an Image

public class Problem_4_Flip_And_Invert_An_Image {
    public int[][] flipAndInvertImage(int[][] arr) {
        int C = arr[0].length;  // Get the number of columns in the input matrix
        for (int[] row: arr) {  // Iterate through each row in the matrix
            for (int i = 0; i < (C + 1) / 2; ++i) {  // Iterate through the first half of each row
                int tmp = row[i] ^ 1;  // Invert the current element and store it in tmp
                row[i] = row[C - 1 - i] ^ 1;  // Invert and swap elements symmetrically from the beginning and end of the row
                row[C - 1 - i] = tmp;  // Update the end element with the temporary value
            }
        }
        return arr;  // Return the modified matrix
    }
}
