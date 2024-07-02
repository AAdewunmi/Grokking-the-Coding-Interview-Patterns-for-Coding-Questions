package Stack;

// Problem Statement: Decimal to Binary Conversion
// LeetCode Question: 1017. Convert to Base -2


import java.util.Stack;

public class Problem_3_DecimalToBinaryConversion {
    public static String decimalToBinary(int num){
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % 2);
            num /= 2;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
