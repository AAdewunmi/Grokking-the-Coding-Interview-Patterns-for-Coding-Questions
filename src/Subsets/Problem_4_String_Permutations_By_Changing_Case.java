package Subsets;

// Problem Statement: String Permutations by changing case (medium)
// LeetCode Question: 784. Letter Case Permutation

import java.util.ArrayList;
import java.util.List;

public class Problem_4_String_Permutations_By_Changing_Case {
    public List<String> findLetterCaseStringPermutations(String str){
        List<String> permutations = new ArrayList<>();
        if (str == null) return permutations;
        permutations.add(str);
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                int n = permutations.size();
                for (int j = 0; j < n; j++) {
                    char[] chs = permutations.get(j).toCharArray();
                    if (Character.isUpperCase(chs[i])) {
                        chs[i] = Character.toLowerCase(chs[i]);
                    } else {
                        chs[i] = Character.toUpperCase(chs[i]);
                    }
                    permutations.add(String.valueOf(chs));
                }
            }
        }
        return permutations;
    }
}
