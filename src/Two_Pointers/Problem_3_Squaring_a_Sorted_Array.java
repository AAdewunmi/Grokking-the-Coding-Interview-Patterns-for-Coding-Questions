package Two_Pointers;

// Problem Statement: Squaring a Sorted Array (easy)
// LeetCode Question: 977. Squares of a sorted array

public class Problem_3_Squaring_a_Sorted_Array {
    public static int[] makeSquares(int[] arr){
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIndex = n - 1;
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIndex--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIndex--] = rightSquare;
                right--;
            }
        }
        return squares;
    }
}
