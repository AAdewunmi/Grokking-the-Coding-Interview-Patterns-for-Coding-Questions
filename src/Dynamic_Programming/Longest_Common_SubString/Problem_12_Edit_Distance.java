package Dynamic_Programming.Longest_Common_SubString;

// Problem Statement: Edit Distance
// LeetCode Question: 72. Edit Distance

public class Problem_12_Edit_Distance {
    // Brute Force Approach
    public int findMinOperations(String s1, String s2) {
        return findMinOperationsRecursive(s1, s2, 0, 0);
    }

    private int findMinOperationsRecursive(String s1, String s2, int i1, int i2) {

        // if we have reached the end of s1, then we have to insert all the remaining characters of s2
        if(i1 == s1.length())
            return s2.length() - i2;

        // if we have reached the end of s2, then we have to delete all the remaining characters of s1
        if(i2 == s2.length())
            return s1.length() - i1;

        // If the strings have a matching character, we can recursively match for the remaining lengths.
        if(s1.charAt(i1) == s2.charAt(i2))
            return findMinOperationsRecursive(s1, s2, i1+1, i2+1);

        int c1 = 1 + findMinOperationsRecursive(s1, s2, i1+1, i2); //perform deletion
        int c2 = 1 + findMinOperationsRecursive(s1, s2, i1, i2+1); //perform insertion
        int c3 = 1 + findMinOperationsRecursive(s1, s2, i1+1, i2+1); // perform replacement

        return  Math.min(c1, Math.min(c2, c3));
    }

    // Top-down Dynamic Programming with Memoization
    public int findMinOperations_1(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length()+1][s2.length()+1];
        return findMinOperationsRecursive(dp, s1, s2, 0, 0);
    }

    private int findMinOperationsRecursive(Integer[][] dp, String s1, String s2, int i1, int i2) {

        if(dp[i1][i2] == null) {
            // if we have reached the end of s1, then we have to insert all the remaining characters of s2
            if(i1 == s1.length())
                dp[i1][i2] = s2.length() - i2;

                // if we have reached the end of s2, then we have to delete all the remaining characters of s1
            else if(i2 == s2.length())
                dp[i1][i2] = s1.length() - i1;

                // If the strings have a matching character, we can recursively match for the remaining lengths
            else if(s1.charAt(i1) == s2.charAt(i2))
                dp[i1][i2] = findMinOperationsRecursive(dp, s1, s2, i1+1, i2+1);
            else {
                int c1 = findMinOperationsRecursive(dp, s1, s2, i1+1, i2); //delete
                int c2 = findMinOperationsRecursive(dp, s1, s2, i1, i2+1); //insert
                int c3 = findMinOperationsRecursive(dp, s1, s2, i1+1, i2+1); //replace
                dp[i1][i2] = 1 + Math.min(c1, Math.min(c2, c3));
            }
        }

        return dp[i1][i2];
    }

    // Bottom-up Dynamic Programming
    public int findMinOperations_3(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        // if s2 is empty, we can remove all the characters of s1 to make it empty too
        for(int i1=0; i1 <= s1.length(); i1++)
            dp[i1][0] = i1;

        // if s1 is empty, we have to insert all the characters of s2
        for(int i2=0; i2 <= s2.length(); i2++)
            dp[0][i2] = i2;

        for(int i1=1; i1 <= s1.length(); i1++) {
            for(int i2=1; i2 <= s2.length(); i2++) {
                // If the strings have a matching character, we can recursively match for the remaining lengths
                if(s1.charAt(i1-1) == s2.charAt(i2-1))
                    dp[i1][i2] = dp[i1-1][i2-1];
                else
                    dp[i1][i2] = 1 + Math.min(dp[i1-1][i2], //delete
                            Math.min(dp[i1][i2-1], //insert
                                    dp[i1-1][i2-1])); //replace
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
