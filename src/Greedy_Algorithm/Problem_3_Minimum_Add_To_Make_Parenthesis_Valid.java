package Greedy_Algorithm;

// Problem Statement: Minimum Add to Make Parentheses Valid (medium)
// LeetCode Question: 921. Minimum Add to Make Parentheses Valid

public class Problem_3_Minimum_Add_To_Make_Parenthesis_Valid {
    public int minAddToMakeValid(String S){
        int balance = 0, counter = 0;
        for (char c : S.toCharArray()){
            balance += c == '(' ? 1 : - 1;
            if (balance == - 1) {
                counter++;
                balance++;
            }
        }
        return counter + balance;
    }
}
