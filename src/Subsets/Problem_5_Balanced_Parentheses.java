package Subsets;

// Problem Statement: Balanced Parentheses (hard)
// LeetCode Question: 22. Generate Parentheses

import java.util.ArrayList;
import java.util.List;

public class Problem_5_Balanced_Parentheses {

    public List<String> generateValidParentheses (int num){
        List<String> result = new ArrayList<String>();
        char[] parenthesesString = new char[2 * num];
        generateValidParenthesesRecursively(num, 0, 0, parenthesesString, 0, result);
        return result;
    }

    private static void generateValidParenthesesRecursively(int num, int openCount,
                                                            int closeCount, char[] parenthesesString, int index, List<String> result) {
        if (openCount == num && closeCount == num) {
            result.add(new String(parenthesesString));
        } else {
            if (openCount < num) {
                parenthesesString[index] = '(';
                generateValidParenthesesRecursively(num, openCount + 1, closeCount, parenthesesString, index + 1, result);
            }
            if (openCount > closeCount) {
                parenthesesString[index] = ')';
                generateValidParenthesesRecursively(num, openCount, closeCount + 1, parenthesesString, index + 1, result);
            }
        }
    }

}
