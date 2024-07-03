package Subsets;

// Problem Statement: Evaluate Expression (hard)
// LeetCode Question: 241. Different Ways to Add Parentheses

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_7_Evaluate_Expression {
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

    public List<Integer> diffWaysToEvaluateExpression(String input) {
        if (map.containsKey(input))
            return map.get(input);
        List<Integer> result = new ArrayList<>();
        // base case: if the input string is a number, parse and return it.
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
        } else {
            for (int i = 0; i < input.length(); i++) {
                char chr = input.charAt(i);
                if (!Character.isDigit(chr)) {
                    List<Integer> leftParts = diffWaysToEvaluateExpression(input.substring(0, i));
                    List<Integer> rightParts = diffWaysToEvaluateExpression(input.substring(i + 1));
                    for (int part1 : leftParts) {
                        for (int part2 : rightParts) {
                            if (chr == '+')
                                result.add(part1 + part2);
                            else if (chr == '-')
                                result.add(part1 - part2);
                            else if (chr == '*')
                                result.add(part1 * part2);
                        }
                    }
                }
            }
        }
        map.put(input, result);
        return result;
    }
}
