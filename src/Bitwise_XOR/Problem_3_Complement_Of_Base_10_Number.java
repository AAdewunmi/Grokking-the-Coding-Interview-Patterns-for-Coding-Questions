package Bitwise_XOR;

// Problem Statement: Complement of Base 10 Number (medium)
// LeetCode Question: 1009. Complement of Base 10 Integer

public class Problem_3_Complement_Of_Base_10_Number {
    public int bitwiseComplement(int num){
        int bitCount = 0;
        int n = num;
        while (n > 0) {
            bitCount++;
            n = n >> 1;
        }
        int all_bits_set = (int) Math.pow(2, bitCount) - 1;
        return num ^ all_bits_set;
    }
}
