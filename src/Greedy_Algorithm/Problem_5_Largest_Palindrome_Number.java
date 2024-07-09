package Greedy_Algorithm;

// Problem Statement: Largest Palindromic Number (Medium)
// LeetCode Question: 2384. Largest Palindromic Number

import java.util.Arrays;

public class Problem_5_Largest_Palindrome_Number {
    public String largestPalindromic(String num) {
        // Count the frequency of each digit in the input number
        int[] freq = new int[10];  // Initialize a frequency array for digits 0-9
        for (int i = 0; i < num.length(); i++) {
            freq[num.charAt(i) - '0']++;  // Increment the count for each digit
        }

        StringBuilder firstHalf = new StringBuilder();
        String middle = "";
        for (int i = 9; i >= 0; i--) {  // Iterate from the highest digit (9) to the lowest (0)
            if (freq[i] % 2 != 0 && middle.isEmpty()) {  // Check if the digit count is odd and middle is empty
                middle = Integer.toString(i);  // Assign the largest odd-count digit as the middle digit
            }
            char[] half = new char[freq[i] / 2];
            Arrays.fill(half, (char) (i + '0'));
            firstHalf.append(new String(half));  // Add half of the even-count digits to the first half
        }

        // Handle special cases
        if (firstHalf.length() == 0) {
            return middle.isEmpty() ? "0" : middle;  // Return the middle digit or "0"
        } else if (firstHalf.toString().matches("^0+$")) {
            return "0";  // Case for multiple zeros
        }
        // Construct the final palindrome
        return firstHalf.toString() + middle + firstHalf.reverse().toString();  // Concatenate the first half, middle digit, and the reversed first half
    }
}
