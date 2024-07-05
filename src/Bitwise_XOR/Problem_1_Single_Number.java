package Bitwise_XOR;

// Problem Statement: Single Number
// LeetCode Question: 136. Single Number

public class Problem_1_Single_Number {
    public int findSingleNumber(int[] arr){
        int num = 0;
        for (int i = 0; i < arr.length; i++) num = num ^ arr[i];
        return num;
    }
}
