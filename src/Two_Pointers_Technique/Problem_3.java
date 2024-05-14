package Two_Pointers_Technique;

// Problem Statement: Squaring a Sorted Array (easy)
// LeetCode Question: 26. Remove Duplicates from Sorted Array

public class Problem_3 {
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
