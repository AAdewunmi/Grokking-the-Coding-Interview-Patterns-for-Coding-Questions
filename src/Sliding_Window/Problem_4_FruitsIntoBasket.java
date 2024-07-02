package Sliding_Window;

// Problem Statement: Fruits into Baskets (medium)
// LeetCode Question: 904. Fruit Into Baskets

import java.util.HashMap;
import java.util.Map;

public class Problem_4_FruitsIntoBasket {
    public int totalFruit(char[] arr){
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);
            while(fruitFrequencyMap.size() > 2){
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
                if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
